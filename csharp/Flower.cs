using UnityEngine;

/// <summary>
/// Class for handling flowers. Has a bool whether it has nectar or not and two colours to represent those states. Can change its state.
/// </summary>
public class Flower : MonoBehaviour
{
    // Blossom colours
    [SerializeField] private Material hasNectarColour;
    [SerializeField] private Material hasNoNectarColour;
    private Renderer blossom;
    
    // Nectar state
    private bool hasNectar;

    
    // Start is called before the first frame update
    void Start()
    {
        blossom = transform.GetChild(0).GetComponent<Renderer>();
        hasNectar = true;
    }

    /// <summary>
    /// Returns whether the flower has nectar.
    /// </summary>
    public bool HasNectar => hasNectar;

    /// <summary>
    /// Set hasNectar to false and changes the blossom's colour to hasNoNectarColour.
    /// </summary>
    public void RemoveNectar()
    {
        hasNectar = false;
        blossom.material = hasNoNectarColour;
    }

    /// <summary>
    /// Set hasNectar to true and changes the blossom's colour to hasNectarColour.
    /// </summary>
    public void ResetNectar()
    {
        hasNectar = true;
        blossom.material = hasNectarColour;
    }
}
