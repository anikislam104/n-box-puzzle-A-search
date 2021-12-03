package AStarSearch;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
class TheComparator implements java.util.Comparator<Node>{


    @Override
    public int compare(Node o1, Node o2) {
        if(o1.fn<o2.fn) return -1;
        else if(o1.fn>o2.fn) return 1;
        else return 0;

    }
}


public class HammingDistance {
    public static void main(String[] args) {
        System.out.println("Enter n:");
        Scanner scanner=new Scanner(System.in);
        String n1=scanner.nextLine();
        int n=Integer.parseInt(n1);
        n=n*n-1;
        int rc= (int) Math.sqrt(n+1);
        int puzzle[][]=new int[rc][rc];
        int exploredNodes=0,expandedNodes=0;
        //System.out.println(rc);
        int inv = 0, isInv = 0;

        if(n%2==0) {

            //puzzle = new int[3][3];
            for (int i = 0; i < rc; i++) {
                for (int j = 0; j < rc; j++) {
                    String s = scanner.nextLine();
                    puzzle[i][j] = Integer.parseInt(s);
                }
            }
            int[] arr = new int[n + 1];
            int loop = 0;
            for (int i = 0; i < rc; i++) {
                for (int j = 0; j < rc; j++) {
                    arr[loop] = puzzle[i][j];
                    loop++;
                }
            }
            int blankRow = 0;
            for (int i = 0; i < rc; i++) {
                for (int j = 0; j < rc; j++) {
                    if (puzzle[i][j] == 0) {
                        blankRow = i;
                    }
                }
            }
            for (int i = 0; i < rc * rc; i++) {
                for (int j = i; j < rc * rc; j++) {
                    if (arr[i] > arr[j] && arr[i] != 0 && arr[j] != 0) {
                        inv++;
                    }
                }
            }

            if (inv % 2 == 0) isInv = 1;
            else isInv = 0;
        }


        else if(n%2!=0) {
            //puzzle = new int[4][4];
            for (int i = 0; i < rc; i++) {
                for (int j = 0; j < rc; j++) {
                    String s = scanner.nextLine();
                    puzzle[i][j] = Integer.parseInt(s);
                    System.out.println(puzzle[i][j]);
                }
            }
            int[] arr = new int[n + 1];
            int loop = 0;
            for (int i = 0; i < rc; i++) {
                for (int j = 0; j < rc; j++) {
                    arr[loop] = puzzle[i][j];
                    loop++;
                }
            }
            int blankRow = 0;
            for (int i = 0; i < rc; i++) {
                for (int j = 0; j < rc; j++) {
                    if (puzzle[i][j] == 0) {
                        blankRow = i;
                    }
                }
            }
            for (int i = 0; i < rc * rc; i++) {
                for (int j = i; j < rc * rc; j++) {
                    if (arr[i] > arr[j] && arr[i]!=0 && arr[j]!=0) {
                        inv++;
                    }
                }
            }

            if(blankRow%2!=0){
                if(inv%2==0){
                    isInv=1;
                }
                else {
                    isInv=0;
                }
            }
            else{
                if(inv%2==0){
                    isInv=0;
                }
                else {
                    isInv=1;
                }
            }
        }






        if (isInv == 1) {
            System.out.println("gg");
                exploredNodes++;
                ArrayList<Node> closedNodes = new ArrayList<>();
                PriorityQueue<Node> open = new PriorityQueue<Node>(new TheComparator());
                Node searchNode = new Node(puzzle, 0, null);
                searchNode.gn=0;
                Node currentNode = searchNode;
                open.add(searchNode);
                int i = 1;
                while (true) {
                    searchNode = open.poll();
                    closedNodes.add(searchNode);
                    assert searchNode != null;
                    if (searchNode.HammingDistance(searchNode.current, rc) == 0) {
                        ArrayList<Node> finalPath = new ArrayList<>();
                        closedNodes.add(searchNode);
                        while (searchNode.prevNode != null) {
                            finalPath.add(searchNode);
                            searchNode = searchNode.prevNode;
                        }
                        finalPath.add(searchNode);
                        System.out.println("cost= "+(finalPath.size()-1));
                        System.out.println("Explored nodes= "+exploredNodes);
                        System.out.println("Expanded nodes= "+closedNodes.size());
                        System.out.println("Path:");
                        for (int k = finalPath.size() - 1; k >= 0; k--) {
                            finalPath.get(k).printMatrix(rc);
                            System.out.println();
                        }
                        break;
                    }
                    int[][] up = searchNode.moveUp(searchNode.current, rc);
                    Node upNode = new Node(up, i, searchNode);
//                System.out.println("up");
//                upNode.printMatrix(rc);
                    int[][] down = searchNode.moveDown(searchNode.current, rc);
                    Node downNode = new Node(down, i, searchNode);
//                System.out.println("d");
//                downNode.printMatrix(rc);
                    int[][] right = searchNode.moveRight(searchNode.current, rc);
                    Node rightNode = new Node(right, i, searchNode);
//                System.out.println("r");
//                rightNode.printMatrix(rc);
                    int[][] left = searchNode.moveLeft(searchNode.current, rc);
                    Node leftNode = new Node(left, i, searchNode);
//                System.out.println("l");
//                leftNode.printMatrix(rc);
                    int upH = currentNode.HammingDistance(up, rc);
                    int downH = currentNode.HammingDistance(down, rc);
                    int rightH = currentNode.HammingDistance(right, rc);
                    int leftH = currentNode.HammingDistance(left, rc);

                    for (int j = 0; j < closedNodes.size(); j++) {
                        if (upNode.isEqual(closedNodes.get(j).current,rc)) {
                            upH = Integer.MAX_VALUE - 1000;
                        }
                        if (downNode.isEqual(closedNodes.get(j).current,rc)) {
                            downH = Integer.MAX_VALUE - 1000;
                        }
                        if (rightNode.isEqual(closedNodes.get(j).current,rc)) {
                            rightH = Integer.MAX_VALUE - 1000;
                        }
                        if (leftNode.isEqual(closedNodes.get(j).current,rc)) {
                            leftH = Integer.MAX_VALUE - 1000;
                        }
                    }
                    upNode.gn=searchNode.gn+1;
                    downNode.gn=searchNode.gn+1;
                    rightNode.gn=searchNode.gn+1;
                    leftNode.gn=searchNode.gn+1;
                    upNode.fn = searchNode.gn+1 + upH;
                    downNode.fn = searchNode.gn+1 + downH;
                    rightNode.fn = searchNode.gn+1 + rightH;
                    leftNode.fn = searchNode.gn+1 + leftH;


                    if (upH == 0) {
                        ArrayList<Node> finalPath = new ArrayList<>();
                        closedNodes.add(upNode);
                        searchNode = upNode;
                        while (searchNode.prevNode != null) {
                            finalPath.add(searchNode);
                            searchNode = searchNode.prevNode;
                        }
                        finalPath.add(searchNode);
                        System.out.println("cost= "+(finalPath.size()-1));
                        System.out.println("Explored nodes= "+exploredNodes);
                        System.out.println("Expanded nodes= "+closedNodes.size());
                        System.out.println("Path:");
                        for (int k = finalPath.size() - 1; k >= 0; k--) {
                            finalPath.get(k).printMatrix(rc);
                            System.out.println();
                        }
                        break;
                    }
                    if (downH == 0) {
                        ArrayList<Node> finalPath = new ArrayList<>();
                        closedNodes.add(downNode);
                        searchNode = downNode;
                        while (searchNode.prevNode != null) {
                            finalPath.add(searchNode);
                            searchNode = searchNode.prevNode;
                        }

                        finalPath.add(searchNode);
                        System.out.println("cost= "+(finalPath.size()-1));
                        System.out.println("Explored nodes= "+exploredNodes);
                        System.out.println("Expanded nodes= "+closedNodes.size());
                        System.out.println("Path:");
                        for (int k = finalPath.size() - 1; k >= 0; k--) {
                            finalPath.get(k).printMatrix(rc);
                            System.out.println();
                        }
                        break;
                    }
                    if (rightH == 0) {
                        ArrayList<Node> finalPath = new ArrayList<>();
                        closedNodes.add(rightNode);
                        searchNode = rightNode;
                        while (searchNode.prevNode != null) {
                            finalPath.add(searchNode);

                            searchNode = searchNode.prevNode;
                        }
                        finalPath.add(searchNode);
                        System.out.println("cost= "+(finalPath.size()-1));
                        System.out.println("Explored nodes= "+exploredNodes);
                        System.out.println("Expanded nodes= "+closedNodes.size());
                        System.out.println("Path:");
                        for (int k = finalPath.size() - 1; k >= 0; k--) {
                            finalPath.get(k).printMatrix(rc);
                            System.out.println();
                        }
                        break;
                    }
                    if (leftH == 0) {
                        ArrayList<Node> finalPath = new ArrayList<>();
                        closedNodes.add(leftNode);
                        searchNode = leftNode;
                        while (searchNode.prevNode != null) {
                            finalPath.add(searchNode);
                            searchNode = searchNode.prevNode;
                        }
                        finalPath.add(searchNode);
                        System.out.println("cost= "+(finalPath.size()-1));
                        System.out.println("Explored nodes= "+exploredNodes);
                        System.out.println("Expanded nodes= "+closedNodes.size());
                        System.out.println("Path:");
                        for (int k = finalPath.size() - 1; k >= 0; k--) {
                            finalPath.get(k).printMatrix(rc);
                            System.out.println();
                        }
                        break;
                    }


                    if (upH<Integer.MAX_VALUE-1000) {
                            open.add(upNode);
                            exploredNodes++;

                    }
                    if (downH<Integer.MAX_VALUE-1000) {
                        open.add(downNode);
                        exploredNodes++;
                    }
                    if (rightH<Integer.MAX_VALUE-1000) {
                        open.add(rightNode);
                        exploredNodes++;

                    }
                    if (leftH<Integer.MAX_VALUE-1000) {
                        open.add(leftNode);
                        exploredNodes++;
                    }

                    i++;

                }
            }
        else {
            System.out.println("Unsolvable");
        }
    }
}




