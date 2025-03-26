import java.util.*;

public class Homework1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String[]> testCases = new ArrayList<>();
        String[] number = new String[9];
        int count = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                if (count == 9) {
                    testCases.add(number);
                }
                number = new String[9];
                count = 0;
            } else {
                number[count++] = line;
            }
        }

        if (count == 9) {
            testCases.add(number);
        }

        for (int i = 0; i < testCases.size(); i++) {
            number = testCases.get(i);
            if (RowCheck(number) && ColumnCheck(number) && SubgridCheck(number)) {
                System.out.println("Case " + (i + 1) + ": True.");
            } else {
                System.out.println("Case " + (i + 1) + ": False.");
            }
        }

        scanner.close();
    }

    public static boolean RowCheck(String[] number){
        int thisInt;

        for(int i = 0; i < 9; i++){
            boolean[] isExist = new boolean[9];
            for(int j = 0; j < 9; j++){
                thisInt = Character.getNumericValue(number[i].charAt(j));
                if(thisInt < 1 || thisInt > 9 || isExist[thisInt - 1]){
                    return false;
                }
                isExist[thisInt - 1] = true;
            }
        }
        return true;
    }

    public static boolean ColumnCheck(String[] number){
        int thisInt;
        
        for(int i = 0; i < 9; i++){
            boolean[] isExist = new boolean[9];
            for(int j = 0; j < 9; j++){
                thisInt = Character.getNumericValue(number[j].charAt(i));
                if(thisInt < 1 || thisInt > 9 || isExist[thisInt - 1]){
                    return false;
                }
                isExist[thisInt - 1] = true;
            }
        }
        return true;
    }

    public static boolean SubgridCheck(String[] number){
        int thisInt;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                boolean[] isExist = new boolean[9];
                for(int m = i*3; m < (i*3 + 3); m++ ){
                    for(int n = j*3; n < (j*3 +3); n++){
                        thisInt = Character.getNumericValue(number[m].charAt(n));
                        if(thisInt < 1 || thisInt > 9 || isExist[thisInt - 1]){
                            return false;
                        }
                        isExist[thisInt - 1] = true;
                    }
                }
            }
        }
        return true;
    }
}
