public class Node {
    int[][] current;
    int fn;
    int gn;
    Node prevNode;

    public Node(int[][] current) {
        this.current = current;
    }

    public Node(int fn) {
        this.fn = fn;
    }

    public Node(Node prevNode) {
        this.prevNode = prevNode;
    }

    public Node(int[][] current, int fn, Node prevNode) {
        this.current = current;
        this.fn = fn;
        this.prevNode = prevNode;
    }

    int[][] moveUp(int[][] arr,int rc) {
        if(rc==3){
            int[][] temp=new int[3][3];
            for(int i=0;i<rc;i++){
                for (int j=0;j<rc;j++){
                    temp[i][j]=arr[i][j];
                }
            }
            int done=0;
            for(int i=0;i<rc;i++){
                if (done==1) break;
                for (int j=0;j<rc;j++){
                    if(temp[i][j]==0 && i!=0){
                        temp[i][j]=temp[i-1][j];
                        temp[i-1][j]=0;
                        done=1;
                        break;
                    }
                }
            }
            return temp;
        }
        else {
            int[][] temp=new int[4][4];
            for(int i=0;i<rc;i++){
                for (int j=0;j<rc;j++){
                    temp[i][j]=arr[i][j];
                }
            }
            int done=0;
            for(int i=0;i<rc;i++){
                if (done==1) break;
                for (int j=0;j<rc;j++){
                    if(temp[i][j]==0 && i!=0){
                        temp[i][j]=temp[i-1][j];
                        temp[i-1][j]=0;
                        done=1;
                        break;
                    }
                }
            }
            return temp;
        }

    }

    int[][] moveDown(int[][] arr,int rc) {
        if(rc==3){
            int[][] temp=new int[3][3];
            for(int i=0;i<rc;i++){
                for (int j=0;j<rc;j++){
                    temp[i][j]=arr[i][j];
                }
            }
            int done=0;
            for(int i=0;i<rc;i++){
                if(done==1) break;
                for (int j=0;j<rc;j++){
                    if(temp[i][j]==0 && i!=rc-1){
                        temp[i][j]=temp[i+1][j];
                        temp[i+1][j]=0;
                        done=1;
                        break;
                    }

                }
            }
            return temp;
        }
        else {
            int[][] temp=new int[4][4];
            for(int i=0;i<rc;i++){
                for (int j=0;j<rc;j++){
                    temp[i][j]=arr[i][j];
                }
            }
            int done=0;
            for(int i=0;i<rc;i++){
                if(done==1) break;
                for (int j=0;j<rc;j++){
                    if(temp[i][j]==0 && i!=rc-1){
                        temp[i][j]=temp[i+1][j];
                        temp[i+1][j]=0;
                        done=1;
                        break;
                    }

                }
            }
            return temp;
        }

    }

    int[][] moveRight(int[][] arr,int rc) {
        if(rc==3){
            int[][] temp=new int[3][3];
            for(int i=0;i<rc;i++){
                for (int j=0;j<rc;j++){
                    temp[i][j]=arr[i][j];
                }
            }
            int done=0;
            for(int i=0;i<rc;i++){
                if(done==1) break;
                for (int j=0;j<rc;j++){
                    if(temp[i][j]==0 && j!=rc-1){
                        temp[i][j]=temp[i][j+1];
                        temp[i][j+1]=0;
                        done=1;
                        break;
                    }
                }
            }
            return temp;
        }
        else {
            int[][] temp=new int[4][4];
            for(int i=0;i<rc;i++){
                for (int j=0;j<rc;j++){
                    temp[i][j]=arr[i][j];
                }
            }
            int done=0;
            for(int i=0;i<rc;i++){
                if(done==1) break;
                for (int j=0;j<rc;j++){
                    if(temp[i][j]==0 && j!=rc-1){
                        temp[i][j]=temp[i][j+1];
                        temp[i][j+1]=0;
                        done=1;
                        break;
                    }
                }
            }
            return temp;
        }
    }

    int[][] moveLeft(int[][] arr,int rc) {
        if(rc==3){
            int[][] temp=new int[3][3];
            for(int i=0;i<rc;i++){
                for (int j=0;j<rc;j++){
                    temp[i][j]=arr[i][j];
                }
            }
            int done=0;
            for(int i=0;i<rc;i++){
                if (done==1) break;
                for (int j=0;j<rc;j++){
                    if(temp[i][j]==0 && j!=0){
                        temp[i][j]=temp[i][j-1];
                        temp[i][j-1]=0;
                        done=1;
                        break;
                    }
                }
            }
            return temp;
        }
        else {
            int[][] temp=new int[4][4];
            for(int i=0;i<rc;i++){
                for (int j=0;j<rc;j++){
                    temp[i][j]=arr[i][j];
                }
            }
            int done=0;
            for(int i=0;i<rc;i++){
                if (done==1) break;
                for (int j=0;j<rc;j++){
                    if(temp[i][j]==0 && j!=0){
                        temp[i][j]=temp[i][j-1];
                        temp[i][j-1]=0;
                        done=1;
                        break;
                    }
                }
            }
            return temp;
        }
    }

    int HammingDistance(int[][] arr,int rc){
        int dis=0;
        if(rc==3){
            int k=1;
            for (int i=0;i<rc;i++){
                for (int j=0;j<rc;j++){
                    if(i==rc-1 && j==rc-1){

                    }
                    else {
                        //ystem.out.println(arr[i][j]+" "+k);
                        if(arr[i][j]!=k){
                            dis++;
                        }
                        k++;
                    }
                }
            }
            return dis;
        }
        else if(rc==4){
            int k=1;
            for (int i=0;i<rc;i++){
                for (int j=0;j<rc;j++){
                    if(i==rc-1 && j==rc-1){

                    }
                    else {
                        //ystem.out.println(arr[i][j]+" "+k);
                        if(arr[i][j]!=k){
                            dis++;
                        }
                        k++;
                    }
                }
            }
            return dis;
        }
        return dis;
    }



    boolean isEqual(int[][] arr,int rc){
        boolean eq=true;
        for (int i=0;i<rc;i++){
            for (int j=0;j<rc;j++){
                if(arr[i][j]!=current[i][j]){
                    eq=false;
                }
            }
        }
        return eq;
    }

    void printMatrix(int rc){
        for (int i=0;i<rc;i++){
            for (int j=0;j<rc;j++){
                if(current[i][j]==0){
                    System.out.print("*");
                    System.out.print("   ");
                }
                else {
                    System.out.print(current[i][j]);
                    System.out.print("   ");
                }
            }
            System.out.println();
            System.out.println();
        }
    }


    int ManhattanDistance(int[][] arr,int rc){
        int sum=0;
        for (int i=0;i<rc;i++){
            for (int j=0;j<rc;j++){
                if(arr[i][j]!=0){
                    int r=Math.abs(i-(arr[i][j]-1)/rc);
                    int c=Math.abs(j-(arr[i][j]-1)%rc);
                    //System.out.println(arr[i][j]+" "+r+" "+c);
                    sum=sum+r+c;
                }
            }
        }
//        System.out.println(sum);
        return sum;
    }

    int linearConflict(int[][] arr,int rc){
        int sum=0;
        for (int i=0;i<rc;i++){
            for (int j=0;j<rc;j++){
                if(arr[i][j]!=0){
//                    int r=Math.abs(i-(arr[i][j]-1)/3);
                    for (int k=j;k<rc;k++){
                        int r1=Math.abs(i-(arr[i][j]-1)/rc);
                        int r2=Math.abs(i-(arr[i][k]-1)/rc);
                        if(r1==0 && r2==0 && arr[i][j]>arr[i][k] && arr[i][k]!=0){
                            //System.out.println(arr[i][j]+" "+arr[i][k]);
                            sum++;
                        }
                    }

                }
            }
        }
//        System.out.println(sum);
        return 2*sum+this.ManhattanDistance(arr,rc);
    }
}
