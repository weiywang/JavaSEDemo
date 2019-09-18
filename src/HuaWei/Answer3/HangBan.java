package HuaWei.Answer3;

import java.util.Map;
import java.util.Scanner;

public class HangBan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String[] lines = scanner.nextLine().trim().split(",");
            String id = lines[0];
            String seat = lines[1];
            String name = lines[2];
            Ticket ticket = new Ticket(id, seat, name);
            PlantFactory.getPlant(id).add(ticket);
        }
        Map<String, Plant> maps = PlantFactory.getMap();
        int m = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < m; i++) {
            String[] lines = scanner.nextLine().trim().split(",");
            String id1 = lines[0];
            String seat1 = lines[1];
            String id2 = lines[2];
            String seat2 = lines[3];
            Plant plant1 = PlantFactory.getPlant(id1);
            Ticket ticket1 = PlantFactory.getPlant(id1).getTicket(seat1);
            plant1.remove(ticket1);
            Ticket ticket2 = new Ticket(id2, seat2, ticket1.getName());
            Plant plant2 = PlantFactory.getPlant(id2);
            plant2.add(ticket2);
        }

        Map<String, Plant> map = PlantFactory.getMap();
        for (String id : map.keySet()) {
            for (Ticket ticket : map.get(id).getTickets()) {
                System.out.println(ticket);
            }
        }
    }
}
