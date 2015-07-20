/**
 * Defines a simple plant with a name, size, and maximum size. Plants can grow,
 * 1 unit at a time, up to their maximum size.
 * 
 * @author Nathan Anneken
 * @version 1.0
 */
public class Plant {

	private String name;
	private int size;
	private int maxSize;

	/**
	 * Constructs a plant with a specified name and maximum size, setting the
	 * initial size of the plant to 0.
	 * 
	 * @param name
	 *            The name of this plant
	 * @param maxSize
	 *            The maximum size of this plant
	 */
	public Plant(String name, int maxSize) {
		this(name, 0, maxSize);
	}

	/**
	 * Constructs a plant with a specified name, size, and maximum size
	 * 
	 * @param name
	 *            The name of this plant
	 * @param size
	 *            The current size of this plant
	 * @param maxSize
	 *            The maximum size of this plant
	 */
	public Plant(String name, int size, int maxSize) {
		this.name = name;
		if (size >= 10 || size < 0)
			throw new IllegalArgumentException("Invalid size");
		else
			this.size = size;
		if (maxSize >= 10 || maxSize <= 0)
			throw new IllegalArgumentException("Invalid max size");
		else
			this.maxSize = maxSize;
	}

	/**
	 * Returns the name of this plant
	 * 
	 * @return A string representation of the name of this plant
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns the size of this plant
	 * 
	 * @return The current size of this plant
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * Returns the maximum size of this plant
	 * 
	 * @return The maximum size of this plant
	 */
	public int getMaxSize() {
		return this.maxSize;
	}

	/**
	 * Increases this plant's height by 1, up to its maximum size
	 */
	public void grow() {
		if (this.size < this.maxSize) {
			this.size = this.size + 1;
		}
	}

	/**
	 * Returns whether this plant has reached full maturity (when the plant's
	 * height reaches its maximum height)
	 * 
	 * @return Whether this plant's current size is equal to its max size
	 */
	public boolean isMature() {
		if (this.size == this.maxSize)
			return true;
		else
			return false;
	}

	/**
	 * Gets the name, size, and maxSize of this plant, as a String, formatted as
	 * in this example: "beans (5, 7)"
	 */
	public String toString() {
		return this.name + " (" + this.size + "," + this.maxSize + ")";
	}

}
