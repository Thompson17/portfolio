using System.Collections.Generic;
using System.Linq;
using UnityEngine;

/// <summary>
/// Stores and handles the information about all flowers and which of them are available for the bees.
/// </summary>
public class BeeManager : MonoBehaviour
{
    // Flower lists
    private GameObject[] flowers;
    private List<GameObject> availableFlowers;
    
    // Time of last list reset
    private float lastReset;
    
    
    // Start is called before the first frame update
    void Start()
    {
        InitFlowers();
        ResetAvailableFlowersAlways();
    }

    // Find all flowers in the Scene.
    void InitFlowers()
    {
        flowers = GameObject.FindGameObjectsWithTag("Flower");
    }

    // Reset the list of available flowers. Reset the nectar of all flowers.
    void ResetAvailableFlowersAlways()
    {
        availableFlowers = flowers.ToList();
        foreach (GameObject flower in availableFlowers)
        {
            flower.GetComponent<Flower>().ResetNectar();
        }
        
    }

    /// <summary>
    /// Gets a random available flower. Deletes that flower from list of available flowers.
    /// </summary>
    /// <returns>The flower gameObject or null if none found.</returns>
    public GameObject GetAvailableFlower()
    {
        if (availableFlowers.Count < 1)
        {
            return null;
        }
        int index = Random.Range(0, availableFlowers.Count);
        GameObject flower = availableFlowers[index];
        availableFlowers.RemoveAt(index);
        return flower;
    }

    /// <summary>
    /// Remove a flower from the list of available flowers.
    /// </summary>
    /// <param name="flower">The flower to remove from the list of  available flowers.</param>
    /// <returns>True if removed and false if not on the list.</returns>
    public bool RemoveFlowerFromList(GameObject flower)
    {
        return availableFlowers.Remove(flower);
    }

    /// <summary>
    /// Reset the list of available flowers if not recently reset.
    /// </summary>
    /// <returns>True if list was reset or false if last reset was less than 10 seconds ago.</returns>
    public bool ResetAvailableFlowers()
    {
        if (Time.time - lastReset < 10)
        {
            return false;
        }
        ResetAvailableFlowersAlways();
        return true;
    }
}
