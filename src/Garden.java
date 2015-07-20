import java.util.ArrayList;

/**
 * Defines a simple garden that can store plant objects. The plants grow (the
 * tick() method makes time elapse, with all plants growing as appropriate.
 * Fully mature plants can be harvested.
 * 
 * @author Nathan Anneken
 * @version 1.0
 */
public class Garden {

	private Plant[][] plantedPlants;
	private ArrayList<Plant> harvestedPlants;

	/**
	 * Constructs a garden with specified rows and columns
	 * 
	 * @param rows
	 *            The number of rows in this garden
	 * @param columns
	 *            The number of plants in each row
	 */
	public Garden(int rows, int columns) {
		plantedPlants = new Plant[columns][rows];
		harvestedPlants = new ArrayList<Plant>();
	}

	/**
	 * Plants a plant in the first available location, if there is one.
	 * 
	 * @param plant
	 *            The plant to be planted in this garden
	 */
	public void addPlant(Plant plant) {
		outerloop: for (int row = 0; row < this.plantedPlants[0].length; row++) {
			for (int column = 0; column < this.plantedPlants.length; column++) {
				if (this.plantedPlants[column][row] == (null)) {
					this.plantedPlants[column][row] = new Plant(
							plant.getName(), plant.getSize(),
							plant.getMaxSize());
					break outerloop;
				} // end if
			} // end column for
		} // end row for
	}// end addPlant

	/**
	 * Plants a plant in the specified location.
	 * 
	 * @param plant
	 *            The plant to be planted in this garden
	 * @param row
	 *            The row this plant is to be planted in
	 * @param column
	 *            The column this plant is to be planted in
	 */
	public void addPlant(Plant plant, int row, int column) {
		if (this.plantedPlants[column][row] == (null))
			this.plantedPlants[column][row] = new Plant(plant.getName(),
					plant.getSize(), plant.getMaxSize());
		else
			System.out.println("Plant already exists in that location!");
	} // end addPlant

	/**
	 * Gets a String list of all plants that have been harvested.
	 * 
	 * @return A string representation of all harvested plants
	 */
	public String getHarvestedPlantsString() {
		String s = "";
		for (Plant a : this.harvestedPlants)
			s += a.toString() + "\n";
		return s;
	} // end getHarvestedPlantsString

	/**
	 * Gets the plant at a particular location in the garden (null if there is
	 * no plant in that location)
	 * 
	 * @param row
	 *            The row location of this plant
	 * @param col
	 *            The column location of this plant
	 * @return
	 */
	public Plant getPlant(int row, int col) {
		return this.plantedPlants[col][row];
	} // end getPlant

	/**
	 * Gets a count of plants in this garden
	 * 
	 * @return The count of plants in this garden
	 */
	public int getPlantCount() {
		int plantCount = 0;
		for (int row = 0; row < this.plantedPlants[0].length; row++) {
			for (int column = 0; column < this.plantedPlants.length; column++) {
				if (this.plantedPlants[column][row] != (null))
					plantCount++;
			} // end column for
		} // end row for
		return plantCount;
	}

	/**
	 * Gets a String list of all plants that are in the garden (not yet
	 * harvested), including the row and column of each plant.
	 * 
	 * @return A string representation of all plants currently planted in this
	 *         garden
	 */
	public String getPlantedPlantsString() {
		String s = "";
		for (int row = 0; row < this.plantedPlants[0].length; row++) {
			for (int column = 0; column < this.plantedPlants.length; column++) {
				if (this.plantedPlants[column][row] != (null))
					s += "[" + row + "][" + column + "] "
							+ plantedPlants[column][row].toString() + "\n";
			} // end column for
		} // end row for
		return s;
	}

	/**
	 * Collects all plants that have reached their maximum size, adding them to
	 * the harvest.
	 */
	public void harvestMaturePlants() {
		for (int row = 0; row < this.plantedPlants[0].length; row++) {
			for (int column = 0; column < this.plantedPlants.length; column++) {
				if (this.plantedPlants[column][row] != (null)) {
					if (this.plantedPlants[column][row].isMature()) {
						this.harvestedPlants
								.add(this.plantedPlants[column][row]);
						this.plantedPlants[column][row] = null;
					} // end if
				} // end if
			} // end column for
		} // end row for
	} // end harvestMaturePlants

	/**
	 * Advances time by one unit, causing all plants to grow a little.
	 */
	public void tick() {
		for (int row = 0; row < this.plantedPlants[0].length; row++) {
			for (int column = 0; column < this.plantedPlants.length; column++) {
				if (this.plantedPlants[column][row] != (null)) {
					this.plantedPlants[column][row].grow();
				} // end if
			} // end column for
		} // end row for
	} // end tick

	/**
	 * Returns a String representation of the garden, with 2 characters and a
	 * space used for each location in the garden.
	 */
	public String toString() {
		String s = "";
		for (int row = 0; row < this.plantedPlants[0].length; row++) {
			for (int column = 0; column < this.plantedPlants.length; column++) {
				if (this.plantedPlants[column][row] == (null))
					s += "--  ";
				else {
					s += this.plantedPlants[column][row].getName().substring(0,
							1)
							+ this.plantedPlants[column][row].getSize() + "  ";
				} // end if

			} // end column for
			s += "\n";
		} // end row for
		return s;
	} // end toString

} // end Garden
