package Practice;

public class DigArtifacts {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] a = new boolean[n][n];

        for(int i=0; i < dig.length; i++ ){
            a[dig[i][0]][dig[i][1]] = true;
        }

        int count = 0;
        for(int i=0; i < artifacts.length; i++){
            boolean found = true;
            for(int j=artifacts[i][0]; j<=artifacts[i][2]; j++){
                for(int k=artifacts[i][1]; j<=artifacts[i][3]; j++){
                    if(a[j][k] == false){
                        found = false;
                        break;
                    }
                }
                if(found==false)
                    break;
            }
            if(found)
                count++;
        }
        return count;
    }
}
