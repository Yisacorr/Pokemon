public interface Water_Interface{

    public String specialMenu = "1. Water Gun\n2. Bubble Beam\n3. Waterfall";
    public int numSpecialMenuItems = 3;

    /** A calling to make the method waterGun to be implemented on Staryu and Squirtle class
     * @param p Pokemon
     * @return a string of the interaction.
     */
    public String waterGun(Pokemon p);
    /** A calling to make the method bubbleBeam to be implemented on Staryu and Squirtle class
     *  @param p Pokemon
     *  @return a string of the interaction.
     */
    public String bubbleBeam(Pokemon p);
    /** A calling to make the method waterFall to be implemented on Staryu and Squirtle class
     *  @param p Pokemon
     *  @return a string of the interaction.
     */
    public String waterFall(Pokemon p);
}
