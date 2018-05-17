package pascalsTriangle;

import java.util.Scanner;

public class Parking {
    public static void main(String args[]) throws Exception {

	Scanner in = new Scanner(System.in);
	int lands = in.nextInt();
	int rows = in.nextInt();
	int columns = in.nextInt();
	int cost[] = new int[lands];
	Point start[] = new Point[lands];
	Point end[] = new Point[lands];
	int overlaps[][];
	int minX = 0, minY = 0, maxX = 0, maxY = 0;

	for (int i = 0; i < lands; i++) {
	    start[i] = new Point();
	    end[i] = new Point();
	    start[i].x = in.nextInt();
	    start[i].y = in.nextInt();
	    end[i].x = in.nextInt();
	    end[i].y = in.nextInt();
	    cost[i] = in.nextInt();

	    if (minX > start[i].x)
		minX = start[i].x;
	    if (minY > start[i].y)
		minY = start[i].y;

	    if (maxX < end[i].x)
		maxX = end[i].x;
	    if (maxY < end[i].y)
		maxY = end[i].y;
	}

	overlaps = new int[maxX + 1][maxY + 1];
	int currentCost = 0, prevCost = 0;
	for (int i = 0; i < lands; i++) {
	    currentCost = cost[i];

	    for (int j = start[i].x; j <= end[i].x; j++) {
		for (int k = start[i].y; k <= end[i].y; k++) {
		    prevCost = overlaps[j][k];
		    if (prevCost == 0) {
			overlaps[j][k] = currentCost;
		    } else if (prevCost > 0) {
			overlaps[j][k] = (-1) * (prevCost + currentCost);
		    } else if (prevCost < 0) {
			overlaps[j][k] = (prevCost - currentCost);
		    }
		}
	    }
	}

	double maxCost = 0;
	for (int j = 0; j <= maxX; j++) {
	    for (int k = 0; k <= maxY; k++) {
		if (overlaps[j][k] < 0) {
		    maxCost += (-1) * overlaps[j][k];
		}
	    }
	}

	System.out.printf("%.0f\n", maxCost);

	in.close();

    }

}

class Point {
    public int x, y;
}
