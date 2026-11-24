using UnityEngine;
using Panda;
using UnityEngine.AI;

/// <summary>
/// Class for the bee behaviour. Initialises object references on Start() but otherwise is controlled by the PandaBT tasks.
/// </summary>
public class Bee : MonoBehaviour
{
    // References to other objects
    private BeeManager beeManager;
    private GameObject hive;
    private GameObject flower;
    private GameObject target;
    private NavMeshAgent navAgent;

    // Has nectar or no nectar
    private bool hasNectar;

    // Start is called before the first frame update
    void Start()
    {
        // Initialise object references
        beeManager = GameObject.Find("BeeManager").GetComponent<BeeManager>();
        hive = GameObject.Find("Hive");
        navAgent = GetComponent<NavMeshAgent>();
    }

    /*
        PandaBT Tasks

        Conditions
    */
    // Succeeds if the bee has nectar.
    [Task]
    bool BeeHasNectar()
    {
        return hasNectar;
    }

    // Succeeds if the flower has nectar. Fails if there is no flower.
    [Task]
    bool FlowerHasNectar()
    {
        if (flower == null)
        {
            return false;
        }

        return flower.GetComponent<Flower>().HasNectar;
    }

    /*
        PandaBT Tasks

        Actions
    */
    // Moves bee to hive or flower depending on the string parameter. Succeeds when reaching the destination. Fails when incorrect input or no valid target.
    [Task]
    void MoveTo(string targetName)
    {
        switch (targetName)
        {
            case "Flower":
                target = flower;
                break;
            case "Hive":
                target = hive;
                break;
            // Incorrect string input
            default:
                ThisTask.Fail();
                return;
        }

        // No target
        if (target == null)
        {
            ThisTask.Fail();
            return;
        }

        // Move to destination
        Vector3 destination = target.transform.position;
        navAgent.SetDestination(destination);

        // Succeed once target reached
        Vector3 distanceToTarget = destination - transform.position;
        distanceToTarget.y = 0;
        if (Vector3.SqrMagnitude(distanceToTarget) < 0.1f)
        {
            ThisTask.Succeed();
        }
    }

    // Gets an available flower from BeeManager. Fails if manager returns null, otherwise succeeds.
    [Task]
    void FindFlower()
    {
        flower = beeManager.GetAvailableFlower();
        if (flower == null)
        {
            ThisTask.Fail();
            return;
        }
        ThisTask.Succeed();
    }

    // Sets flower to null and succeeds.
    [Task]
    void DeselectFlower()
    {
        flower = null;
        ThisTask.Succeed();
    }

    // Removes nectar from flower and adds it to the bee. Fails if there is no flower.
    [Task]
    void PickUpNectar()
    {
        if (flower == null)
        {
            ThisTask.Fail();
            return;
        }
        flower.GetComponent<Flower>().RemoveNectar();
        hasNectar = true;
        ThisTask.Succeed();
    }

    // Drops the nectar and succeeds.
    [Task]
    void DropNectar()
    {
        hasNectar = false;
        ThisTask.Succeed();
    }

    // Calls beeManager.RemoveFlowerFromList(). Succeeds if the call returns true. Fails otherwise.
    [Task]
    void RemoveFlowerFromList()
    {
        if (beeManager.RemoveFlowerFromList(flower))
        {
            ThisTask.Succeed();
            return;
        }
        ThisTask.Fail();
    }

    // Calls beeManager.ResetAvailableFlowers(). Succeeds if the call returns true. Fails otherwise.
    [Task]
    void ResetAvailableFlowers()
    {
        if (beeManager.ResetAvailableFlowers())
        {
            ThisTask.Succeed();
            return;
        }
        ThisTask.Fail();
    }
}
