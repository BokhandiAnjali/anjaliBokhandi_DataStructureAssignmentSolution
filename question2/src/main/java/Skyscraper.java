import java.util.*;

public class Skyscraper {

    public static void main(String[] args) {

        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the total no of floors in the building");

        int noOfFloors = sc.nextInt();
        int max = noOfFloors;

        for (int i = 1; i <= noOfFloors; i++) {
            System.out.println("enter the floor size given on day : " + i);
            list.add(sc.nextInt());
        }

        for (int i = 1; i <= noOfFloors; i++) {
            int floorSize = list.get(i - 1);
            System.out.println("Day: " + i);
            if (max == floorSize) {
                System.out.print(floorSize + " ");
                max--;
                while (!queue.isEmpty() && max == queue.peek()) {
                    System.out.print(queue.poll() + " ");
                    max--;
                }
            } else {
                queue.add(floorSize);
            }
            System.out.println();
        }
    }
}
