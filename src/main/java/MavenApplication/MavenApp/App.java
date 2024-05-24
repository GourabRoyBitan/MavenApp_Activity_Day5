package MavenApplication.MavenApp;
import java.util.*;

/**
 * Hello world!
 *
 */

class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Player player = (Player) obj;
        return name.equals(player.name);
    }
}

class Team {
    private Set<Player> players;

    public Team() {
        players = new HashSet();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public boolean hasPlayer(Player player) {
        return players.contains(player);
    }

    public void displayPlayers() {
        System.out.println("Players in the team:");
        for (Player player : players) {
            System.out.println(player.getName());
        }
    }
}
public class App 
{
    public static void main( String[] args )
    {
    
    	Scanner scanner = new Scanner(System.in);
        Team team = new Team();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add player");
            System.out.println("2. Remove player");
            System.out.println("3. Check if player is on the team");
            System.out.println("4. Display all players");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter player name to add: ");
                    String playerNameToAdd = scanner.nextLine();
                    Player playerToAdd = new Player(playerNameToAdd);
                    team.addPlayer(playerToAdd);
                    System.out.println(playerNameToAdd + " added to the team.");
                    break;
                case 2:
                    System.out.print("Enter player name to remove: ");
                    String playerNameToRemove = scanner.nextLine();
                    Player playerToRemove = new Player(playerNameToRemove);
                    if (team.hasPlayer(playerToRemove)) {
                        team.removePlayer(playerToRemove);
                        System.out.println(playerNameToRemove + " removed from the team.");
                    } else {
                        System.out.println(playerNameToRemove + " is not on the team.");
                    }
                    break;
                case 3:
                    System.out.print("Enter player name to check: ");
                    String playerNameToCheck = scanner.nextLine();
                    Player playerToCheck = new Player(playerNameToCheck);
                    if (team.hasPlayer(playerToCheck)) {
                        System.out.println(playerNameToCheck + " is on the team.");
                    } else {
                        System.out.println(playerNameToCheck + " is not on the team.");
                    }
                    break;
                case 4:
                    team.displayPlayers();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
        }
    }

