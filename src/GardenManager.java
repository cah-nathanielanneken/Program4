import java.util.*;

public class GardenManager {

	/**
	 * A user interface for working with the garden and plant classes that
	 * constructs a garden to a specified row and column size, then allows the
	 * user to interactively print a string representation of the garden, add
	 * plant(s) to the garden, harvest the mature plants in the garden, print
	 * the harvested plants, print the plants currently planted, and make time
	 * pass
	 * 
	 * @param args
	 * @author Nathan Anneken
	 * @version 1.0
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int rows, columns;
		System.out.println("Welcome to the Garden Manager.");
		System.out.println("Lets get started...");
		System.out.print("How many rows will be in your garden? ");
		rows = input.nextInt();
		System.out.print("How many plants will be in each row? ");
		columns = input.nextInt();
		Garden g = new Garden(rows, columns);
		System.out.println("Here is your garden...");
		System.out.println(g.toString());
		System.out.println("-------------------------------");
		int userChoice = 0;
		while (userChoice != 8) {
			System.out.println("1. Show garden");
			System.out.println("2. Plant one plant");
			System.out.println("3. Plant many plants");
			System.out.println("4. Harvest mature plants");
			System.out.println("5. Show harvested plants");
			System.out.println("6. Show what's planted");
			System.out.println("7. Make time pass");
			System.out.println("8. Quit");
			System.out.print("Enter your choice: ");
			userChoice = input.nextInt();
			if (userChoice == 1) {
				System.out.println(g.toString());
			}
			if (userChoice == 2) {
				String name = "";
				input.nextLine();
				System.out.print("Enter one-word plant type: ");
				name = input.nextLine();
				name.trim();
				System.out.print("Enter start size (0-9): ");
				int size = input.nextInt();
				System.out.print("Enter max size (0-9): ");
				int maxSize = input.nextInt();
				System.out.print("Enter row and column: ");
				int row = input.nextInt();
				int column = input.nextInt();
				Plant p = new Plant(name, size, maxSize);
				g.addPlant(p, row, column);
			}
			if (userChoice == 3) {
				String name = "";
				input.nextLine();
				System.out
						.println("This will plant lots of the same type of plant, in the first spots available.");
				System.out.print("Enter one-word plant type: ");
				name = input.nextLine();
				name.trim();
				System.out.print("Enter start size(0-9): ");
				int size = input.nextInt();
				System.out.print("Enter max size (0-9): ");
				int maxSize = input.nextInt();
				System.out.print("How many do you want to plant? ");
				int numberOfPlants = input.nextInt();
				Plant p = new Plant(name, size, maxSize);
				for (int a = 0; a < numberOfPlants; a++)
					g.addPlant(p);
			}
			if (userChoice == 4) {
				g.harvestMaturePlants();
			}
			if (userChoice == 5) {
				System.out.println(g.getHarvestedPlantsString());
			}
			if (userChoice == 6) {
				System.out.println(g.getPlantCount() + " plants:");
				System.out.println(g.getPlantedPlantsString());
			}
			if (userChoice == 7) {
				System.out.print("How many units of time should pass? ");
				int unitsOfTime = input.nextInt();
				input.nextLine();
				for (int b = 0; b < unitsOfTime; b++) {
					g.tick();
				}
			}
			if (userChoice != 8) {
				System.out.println("-------------------------------");
			}

		}
		System.out.println("Goodbye!");
	}
}
