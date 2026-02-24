using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Panda;
using UnityEngine.AI;

public class Enemy : MonoBehaviour
{
    [SerializeField] private GameObject patrolPath;
        [SerializeField] private float attackRange;
        [SerializeField] private float viewRange;
        [SerializeField, Range(0,360)] private float viewAngle;
    
        private List<Transform> waypoints;
        private int currentWaypointIndex;
        private Transform currentWaypoint;

        private NavMeshAgent navAgent;
        private AudioSource audioData;
        private GameObject player;
        
    
        // Start is called before the first frame update
        void Start()
        {
            navAgent = GetComponent<NavMeshAgent>();
            audioData = GetComponent<AudioSource>();
            player = GameObject.Find("Player");
            InitWaypoints();
        }
    
        void InitWaypoints()
        {
            Debug.Log("Initialising Path");
            var pathTransform = patrolPath.transform;
            waypoints = new List<Transform>(pathTransform.childCount);
            int i = 0;
            foreach (Transform child in pathTransform)
            {
                i++;
                waypoints.Add(child);
            }
            currentWaypoint = waypoints[currentWaypointIndex];
        }
    
        bool CheckInRange(Vector3 target, float maxDistance)
        {
            Vector3 offset = target - transform.position;
            offset.y = 0;
            return Vector3.SqrMagnitude(offset) < maxDistance * maxDistance;
        }
    
        // BT Tasks
        // Conditions
        [Task]
        bool PlayerInSight()
        {
            Debug.Log("Entered PlayerInSight");
            if (!CheckInRange(player.transform.position, viewRange))
            {
                return false;

            }
            Debug.Log("Player in range");
            Vector3 dirToPlayer = (player.transform.position - transform.position).normalized;
            if (Vector3.Angle(transform.forward, dirToPlayer) > viewAngle / 2)
            {
                return false;
            }
            Debug.Log("Player in view");
            RaycastHit hit;
            if (!Physics.Raycast(transform.position, dirToPlayer, out hit, viewRange + 1))
            {
                return false;
            }
            Debug.Log("Ray cast");
            Debug.DrawRay(transform.position, dirToPlayer * hit.distance, Color.red);
            if (hit.collider.gameObject != player)
            {
                return false;
            }
            Debug.Log("Player hit by ray");
            return true;
        }
        
        [Task]
        bool CloseToPlayer()
        {
            bool close = CheckInRange(player.transform.position, attackRange);
            Debug.Log("CloseToPlayer: " + close);
            return close;
        }
        
        [Task]
        bool AtCurrentWaypoint()
        {
            bool at = CheckInRange(currentWaypoint.transform.position, 0.1f);
            Debug.Log("AtCurrentWaypoint: " + at);
            return at;
        }
    
        
        // Actions
        [Task]
        void MoveToPlayer()
        {
            Debug.Log("MoveToPlayer");
            navAgent.SetDestination(player.transform.position);
            ThisTask.Succeed();
        }
    
        
        [Task]
        void Attack()
        {
            if (CheckInRange(player.transform.position, attackRange))
            {
                Debug.Log("Oof!");
                navAgent.SetDestination(transform.position);
                audioData.Play(0);
                ThisTask.Succeed();
                return;
            }
            Debug.Log("Attack failed");
            ThisTask.Fail();
        }
    
    
        [Task]
        void SetNextWaypoint()
        {
            Debug.Log("SetNextWaipoint");
            currentWaypointIndex++;
            if (currentWaypointIndex == waypoints.Count)
            {
                currentWaypointIndex = 0;
            }
            currentWaypoint = waypoints[currentWaypointIndex];
            ThisTask.Succeed();
        }
    
        [Task]
        void MoveToWaypoint()
        {
            Debug.Log("MoveToWaypoint");
            navAgent.SetDestination(currentWaypoint.position);
            ThisTask.Succeed();
        }
}
