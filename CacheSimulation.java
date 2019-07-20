//Büşra_Gökmen
//150116027
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CacheSimulation {
static String temp = "default";
    static char output[] = new char[32];
    // function to convert
    // Hexadecimal to Binary Number

   static void hex2bin(char in[]) {
        int j;
        int a = 0;
        int b = 1;
        int c = 2;
        int d = 3;
        int x = 4;
        int sizem;
        sizem = in.length;


        for (j = 0; j < sizem; j++) {//hexadecimal to bit
            if (in[j] == '0') {
                output[j * x + a] = '0';
                output[j * x + b] = '0';
                output[j * x + c] = '0';
                output[j * x + d] = '0';
            } else if (in[j] == '1') {
                output[j * x + a] = '0';
                output[j * x + b] = '0';
                output[j * x + c] = '0';
                output[j * x + d] = '1';
            } else if (in[j] == '2') {
                output[j * x + a] = '0';
                output[j * x + b] = '0';
                output[j * x + c] = '1';
                output[j * x + d] = '0';
            } else if (in[j] == '3') {
                output[j * x + a] = '0';
                output[j * x + b] = '0';
                output[j * x + c] = '1';
                output[j * x + d] = '1';
            } else if (in[j] == 'x') {
                output[j * x + a] = '0';
                output[j * x + b] = '1';
                output[j * x + c] = '0';
                output[j * x + d] = '0';
            } else if (in[j] == '5') {
                output[j * x + a] = '0';
                output[j * x + b] = '1';
                output[j * x + c] = '0';
                output[j * x + d] = '1';
            } else if (in[j] == '6') {
                output[j * x + a] = '0';
                output[j * x + b] = '1';
                output[j * x + c] = '1';
                output[j * x + d] = '0';
            } else if (in[j] == '7') {
                output[j* x + a] = '0';
                output[j * x + b] = '1';
                output[j * x + c] = '1';
                output[j * x + d] = '1';
            } else if (in[j] == '8') {
                output[j * x + a] = '1';
                output[j * x + b] = '0';
                output[j * x + c] = '0';
                output[j * x + d] = '0';
            } else if (in[j] == '9') {
                output[j* x + a] = '1';
                output[j * x + b] = '0';
                output[j * x + c] = '0';
                output[j * x + d] = '1';
            } else if (in[j] == 'a') {
                output[j * x + a] = '1';
                output[j * x + b] = '0';
                output[j * x + c] = '1';
                output[j * x + d] = '0';
            } else if (in[j] == 'b') {
                output[j * x + a] = '1';
                output[j * x + b] = '0';
                output[j * x + c] = '1';
                output[j * x + d] = '1';
            } else if (in[j] == 'c') {
                output[j * x + a] = '1';
                output[j * x + b] = '1';
                output[j * x + c] = '0';
                output[j * x + d] = '0';
            } else if (in[j] == 'd') {
                output[j * x + a] = '1';
                output[j * x + b] = '1';
                output[j * x + c] = '0';
                output[j * x + d] = '1';
            } else if (in[j] == 'e') {
                output[j * x + a] = '1';
                output[j * x + b] = '1';
                output[j * x + c] = '1';
                output[j * x + d] = '0';
            } else if (in[j] == 'f') {
                output[j * x + a] = '1';
                output[j * x + b] = '1';
                output[j * x + c] = '1';
                output[j * x + d] = '1';
            }
        }

    }


    public static void main(String[] args )throws IOException{
       //data structures and variables that I will use
        List<String> operation = new ArrayList<String>();//M L S I
        List<String> operation_address = new ArrayList<String>();
        List<Integer> size = new ArrayList<Integer>();
        List<String> new_data = new ArrayList<String>();
        List<String> partss = new ArrayList<String>();
        List<String> adress = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        int miss_L1I = 0;
        int hit_L1I = 0;
        int eviction_L1I =0;
        int miss_L1D = 0;
        int hit_L1D = 0;
        int eviction_L1D =0;
        int miss_L2 = 0;
        int hit_L2 = 0;
        int eviction_L2 =0;
        int i = 0;
        int n = 0;
        int z =0;
        int k =0;
        int t =0;
        int l = 0;
        int setbit=0;
        int L1s;
        int L1E;
        int L1b;
        int  L2s;
        int  L2E;
        int  L2b;
        int ram_index = 0;
        String current_data = "";
        String MİSS_or_HIT ="";
        String MİSS_or_HIT2 ="";
//Input to building caches
       System.out.print("-L1s ");
        L1s = input.nextInt();
        System.out.print("-L1E ");
        L1E = input.nextInt();
        System.out.print("-L1b ");
        L1b = input.nextInt();
        System.out.print("-L2s ");
        L2s = input.nextInt();
        System.out.print("-L2E ");
        L2E = input.nextInt();
        System.out.print("-L2b ");
        L2b = input.nextInt();

        try (BufferedReader br = new BufferedReader(new FileReader("test_medium.txt")))//read trace file
        {
            String line = null;
            while ((line = br.readLine()) != null) {

                String[] parts2 = line.split(", ");
                if(parts2.length ==2){
                String arr = parts2[0];
                String[] saw = arr.split(" ");
                operation.add(i,saw[0]);
                operation_address.add(i,saw[1]);
                size.add(i,Integer.parseInt(parts2[1]));
                    new_data.add(i," ");
                }

                else if(parts2.length ==3){
                    String arr = parts2[0];
                    String[] saw = arr.split(" ");
                    operation.add(i,saw[0]);
                    operation_address.add(i,saw[1]);
                    size.add(i,Integer.parseInt(parts2[1]));
                    new_data.add(i,parts2[2]);

                }

                i++;
            }
        }
        catch (Exception expe)
        {
            expe.printStackTrace();
        }
        char hexdec[] = new char[32] ;
        int SetofL1I = (int) Math.pow(2,L1s);
         int LineofL1I = L1E;
         int BlockofsetofL1I = (int) Math.pow(2,L1b);
        int SetofL1D = (int) Math.pow(2,L1s);
        int LineofL1D = L1E;
        int BlockofsetofL1D = (int) Math.pow(2,L1b);
         int SetofL2 = (int) Math.pow(2,L2s);
         int LineofL2 = L2E;
         int BlockofsetofL2 = (int) Math.pow(2,L2b);
         int setbitL1I = 0;
         int setbitL2I =0;
         int setbitL1D = 0;
        int setbitL1S = 0;
        int setbitL2D =0;
        int ofsetL1D = 0;
        int ofsetL2 = 0;
        int setbitL2S =0;
         String hex = "";
         int decimal = 0;


       String[][] tagofL1I = new String[SetofL1I][L1E];
        for( i = 0; i < SetofL1I; i++)
        {
            for(int j = 0; j <L1E; j++)
            {
                tagofL1I[i][j] = " ";//en başta tag boş
            }

        }
        int[][]timeL1I =new int[SetofL1I][L1E] ;
        int [][] vL1I= new int[SetofL1I][L1E];
        String[][]dataofL1I = new String[SetofL1I][L1E];

       String[][] tagofL1D = new String[SetofL1D][L1E];

        for( i = 0; i < SetofL1D; i++)
        {
            for(int j = 0; j <L1E; j++)
            {
                tagofL1D[i][j] = " ";//en başta tag boş
            }

        }
        int[][] timeL1D = new int[SetofL1D][L1E];
        int[][] vL1D=new int[SetofL1D][L1E];
        String[][]dataofL1D = new String[SetofL1D][L1E];

       String [][] tagofL2 = new String[SetofL2][L2E];

        for( i = 0; i < SetofL2; i++)
        {
            for(int j = 0; j <L2E; j++)
            {
                tagofL2[i][j] = " ";//en başta tag boş
            }

        }
        int[][] timeL2 = new int[SetofL2][L2E];
        int[][] vL2=new int[SetofL2][L2E];
        String[][]dataofL2 = new String[SetofL2][L2E];


       //read ram file
        File file = new File("ram.txt");//ramden okuduğu belirlenmiş byte sayısına göre data okuyo
        String listString = "";
        try (Scanner scanner = new Scanner(file);) {
            while (scanner.hasNext()) {
                partss.add(scanner.next());
            }

            StringBuilder sb = new StringBuilder();
            for (String s : partss)
            {
                sb.append(s);

            }
            listString = sb.toString();
            int s=0;
            while((2 * BlockofsetofL1D + n)<=listString.length()){
                adress.add(s,listString.substring(n, 2 * BlockofsetofL1D + n));//rami byte sayısına göre adreslere bölüyo
                n += 2 * BlockofsetofL1D;
                s+=1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

             String as = " ";
for (int j=0; j<operation.size(); j++) {

     if (operation.get(j).equals("L")) {//for data load
        hexdec = operation_address.get(j).toCharArray() ;
        hex2bin(hexdec);
        as = new String(output);
        for (i=(31-L1b); i>=(32-L1b-L1s); i--){
            if(L1s==0){
                setbit=0;      }
            else{
                setbitL1I += Math.pow(2,n)*Integer.parseInt(String.valueOf(output[i]));
                n++;}
        }
           setbit = setbitL1D;
         hex = operation_address.get(j);
         decimal=Integer.parseInt(hex,16);

        for(int m=0; m<adress.size(); m++){
            if (m * BlockofsetofL1D == decimal) {
                current_data = adress.get(m);
            }
        }
        for (k=0; k<L1E; k++) {
            if (tagofL1D[setbit][k].equals(as.substring(0, 32 - (L1b + L1s)))){//taglerin örtüşüp örtüşmediğini kontrol ediyo
                hit_L1D += 1;
                MİSS_or_HIT = "hit";
            }
            else {
                miss_L1D+=1;
                MİSS_or_HIT = "miss";
                for (k=0; k<L1E; k++) {
                    if ( vL1D[setbit][k] == 0){//valid biti 0 olan line a yeni tagi ve datayı yazıyo
                        dataofL1D[setbit][k]= current_data;
                        tagofL1D[setbit][k]=as.substring(0,32-(L1b+L1s));
                        vL1D[setbit][k]++;
                        timeL1D[setbit][k] ++;
                        break;
                    }
                    else {
                        eviction_L1D +=1;//eğer tüm valid bitler 1 ise yani line lar doluysa

                        int min = timeL1D[setbit][0];
                        for (l = 1; l < L1E; l++) {
                            if (timeL1D[setbit][l] < min) {
                                min = timeL1D[setbit][l];
                            }
                            t=l;
                        }

                        for (k=0; k<L1E; k++) {//time ı en küçük ve dolu olan line a tagi ve datayı yazıyorum
                            dataofL1D[setbit][t]=current_data;
                            timeL1D[setbit][t]++;
                            tagofL1D[setbit][t]=as.substring(0,32-(L1b+L1s));
                        }
                    }
                    break;
                } } }/////////////////

        n = 0;
        for (i=(31-L2b); i>=(32-L2b-L2s); i--){
            if(L2s==0){
                setbit=0;      }
            else{
                setbitL2D += Math.pow(2,n)*Integer.parseInt(String.valueOf(output[i]));
                n++;}}
        setbit = setbitL2D;

        hex= operation_address.get(j);
        decimal=Integer.parseInt(hex,16);
        for(int m=0; m<adress.size(); m++){
            if (m * BlockofsetofL2 == decimal) {
                current_data = adress.get(m);
            } }
        for (k=0; k<L2E; k++) {
            if (tagofL2[setbit][k].equals(as.substring(0, 32 - (L2b + L2s)))){
                hit_L2 += 1;
                MİSS_or_HIT2 = "hit";  }
            else {
                miss_L2+=1;
                MİSS_or_HIT2 = "miss";
                for (k=0; k<L2E; k++) {
                    if ( vL2[setbit][k] == 0){
                        dataofL2[setbit][k]= current_data;
                        tagofL2[setbit][k]=as.substring(0,32-(L2b+L2s));
                        vL2[setbit][k]++;
                        timeL2[setbit][k] ++;
                        break; }
                    else {
                        eviction_L2 +=1;
                        int min = timeL2[setbit][0];
                        for (l = 1; l < L2E; l++) {
                            if (timeL2[setbit][l] < min) {
                                min = timeL2[setbit][l]; }
                            t=l; }
                        for (k=0; k<L2E; k++) {
                            dataofL2[setbit][t]=current_data;
                            timeL2[setbit][t]++;
                            tagofL2[setbit][t]=as.substring(0,32-(L2b+L2s));
                        } }
                    break;} } }/////////////////

     System.out.println("L" + " " + operation_address.get(j)+","+ size.get(j));
     System.out.println("L1D:"+" " + MİSS_or_HIT +" "+ "L2:"+" " + MİSS_or_HIT2);
         if(MİSS_or_HIT.equals("miss")&&MİSS_or_HIT2.equals("miss")){
             System.out.println("Place in L2 set" + setbitL2D +"," + "L1D set" + setbitL1D);
         }
         else if(MİSS_or_HIT.equals("miss")&&MİSS_or_HIT2.equals("hit")){
             System.out.println("Place in L1D set" + setbitL1D);
         }
         else if(MİSS_or_HIT.equals("hit")&&MİSS_or_HIT2.equals("miss")){
             System.out.println("Place in L1D set" + setbitL2D);
         }setbitL1D = 0;
         setbitL2D = 0;
         n = 0;

    } else if (operation.get(j).equals("S")) {
        hexdec = operation_address.get(j).toCharArray() ;
        hex2bin(hexdec);
        as = new String(output);
        for (i=(31-L2b); i>=(32-L2b-L2s); i--){
            if(L2s==0){
                setbit=0;      }
            else{
                setbitL2S += Math.pow(2,n)*Integer.parseInt(String.valueOf(output[i]));
                n++;} }
        setbit = setbitL2S;
        hex= operation_address.get(j);
        decimal=Integer.parseInt(hex,16);
        for(int m=0; m<adress.size(); m++){
            if (m * BlockofsetofL2 == decimal) {
                current_data = adress.get(m);
            } }
        for (k=0; k<L2E; k++) {
            if (tagofL2[setbit][k].equals(as.substring(0, 32 - (L2b + L2s)))){
                hit_L2 += 1;
                MİSS_or_HIT2 = "hit";//write allocate -->önce rame yeni datayı yazdırıp daha sonra hit olan line a datayı yazdırıyor
                for (i=31; i>=(32-L2b); i--){
                    ofsetL2 += Math.pow(2,z)*Integer.parseInt(String.valueOf(output[i]));
                    z++; }
               for(i=0; i<2*size.get(j); i++ ){
                dataofL2[setbit][k]=dataofL2[setbit][k].replace(dataofL2[setbit][k].charAt(ofsetL2),new_data.get(j).charAt(i));
               ofsetL2 += 1;}}
            else {
                miss_L2+=1;
                MİSS_or_HIT2 = "miss";//no write allocate + write through --> direkt olarak yeni datayı rame yazıyorum ama cachelere yazmıyorum
                 } }/////////////////
        ofsetL1D = 0;
        ofsetL2 = 0;
        n=0;
        z = 0;
         setbitL2S=0;
        for (i=(31-L1b); i>=(32-L1b-L1s); i--){
            if(L1s==0){
                setbit=0;      }
            else{
                setbitL1S += Math.pow(2,n)*Integer.parseInt(String.valueOf(output[i]));
                n++;} }
        setbit = setbitL1S;
        hex= operation_address.get(j);
        decimal=Integer.parseInt(hex,16);
        for(int m=0; m<adress.size(); m++){
            if (m * BlockofsetofL1I == decimal) {
                current_data = adress.get(m);
            } }
        for (k=0; k<L1E; k++) {
            if (tagofL1I[setbit][k].equals(as.substring(0, 32 - (L1b + L1s)))){
                hit_L1D += 1;
                MİSS_or_HIT = "hit";
                for (i=31; i>=(32-L1b); i--){
                    ofsetL1D += Math.pow(2,z)*Integer.parseInt(String.valueOf(output[i]));
                    z++; }
                for(i=0; i<2*size.get(j); i++ ){
                    dataofL1D[setbit][k]=dataofL1D[setbit][k].replace(dataofL1D[setbit][k].charAt(ofsetL1D),new_data.get(j).charAt(i));
                    ofsetL1D += 1;}}
            else {
                miss_L1D+=1;
                MİSS_or_HIT = "miss";
            } }/////////////////
         System.out.println("S" + " " + operation_address.get(j)+","+ size.get(j)+","+ new_data.get(j));
         System.out.println("L1D:" +" "+ MİSS_or_HIT +" "+ "L2:"+" " + MİSS_or_HIT2);
         if(MİSS_or_HIT.equals("miss")&&MİSS_or_HIT2.equals("miss")){
             System.out.println("Place in L2 set" + setbitL2S +"," + "L1D set" + setbitL1S +","+"RAM");
         }
         else if(MİSS_or_HIT.equals("miss")&&MİSS_or_HIT2.equals("hit")){
             System.out.println("Place in L1D set" + setbitL1S+","+"RAM");
         }
         else if(MİSS_or_HIT.equals("hit")&&MİSS_or_HIT2.equals("miss")){
             System.out.println("Place in L1D set" + setbitL2S+","+"RAM");
         }

        ofsetL1D = 0;
        ofsetL2 = 0;
        n=0;
        z = 0;
         setbitL1S=0;

    } else if (operation.get(j).equals("I")) {//instruction load
        hexdec = operation_address.get(j).toCharArray() ;
        hex2bin(hexdec);
        as = new String(output);
        for (i=(31-L1b); i>=(32-L1b-L1s); i--){
       if(L1s==0){
           setbitL1I=0;      }
       else{
            setbitL1I += Math.pow(2,n)*Integer.parseInt(String.valueOf(output[i]));
       n++;} }
        setbit = setbitL1I;
        hex= operation_address.get(j);
        decimal=Integer.parseInt(hex,16);
        for(int m=0; m<adress.size(); m++){
            if (m * BlockofsetofL1I == decimal) {
               current_data = adress.get(m);
            } }
        for (k=0; k<L1E; k++) {
            if (tagofL1I[setbit][k].equals((as.substring(0, 32 - (L1b + L1s)))) ){
                hit_L1I += 1;
                MİSS_or_HIT = "hit";
            }
            else {
                miss_L1I+=1;
                MİSS_or_HIT = "miss";
                for (k=0; k<L1E; k++) {
                    if ( vL1I[setbit][k] == 0){
                        dataofL1I[setbit][k]= current_data;
                        tagofL1I[setbit][k]=as.substring(0,32-(L1b+L1s));
                        vL1I[setbit][k]++;
                        timeL1I[setbit][k] ++;
                          break; }
                    else {
                       eviction_L1I +=1;
                       int min = timeL1I[setbit][0];
            for (l = 1; l < L1E; l++) {
                if (timeL1I[setbit][l] < min) {
                    min = timeL1I[setbit][l]; }
                t=l; }
            for (k=0; k<L1E; k++) {
                            dataofL1I[setbit][t]=current_data;
                            timeL1I[setbit][t]++;
                            tagofL1I[setbit][t]=as.substring(0,32-(L1b+L1s));
                        }
                    }break;} } }/////////////////
        n = 0;
        for (i=(31-L2b); i>=(32-L2b-L2s); i--){
            if(L2s==0){
                setbitL2I=0;      }
            else{
                setbitL2I += Math.pow(2,n)*Integer.parseInt(String.valueOf(output[i]));
                n++;}
            }
        setbit = setbitL2I;
         hex= operation_address.get(j);
         decimal=Integer.parseInt(hex,16);
        for(int m=0; m<adress.size(); m++){
            if (m * BlockofsetofL2 == decimal) {
                current_data = adress.get(m);
            } }
        for (k=0; k<L2E; k++) {
            if (tagofL2[setbit][k].equals(as.substring(0, 32 - (L2b + L2s)))){
                hit_L2 += 1;
                MİSS_or_HIT2 = "hit";}
            else {
                miss_L2+=1;
                MİSS_or_HIT2 = "miss";
                for (k=0; k<L2E; k++) {
                    if ( vL2[setbit][k] == 0){
                        dataofL2[setbit][k]= current_data;
                        tagofL2[setbit][k]=as.substring(0,32-(L2b+L2s));
                        vL2[setbit][k]++;
                        timeL2[setbit][k] ++;
                        break; }
                    else {
                        eviction_L2 +=1;
                        int min = timeL2[setbit][0];
                        for (l = 1; l < L2E; l++) {
                            if (timeL2[setbit][l] < min) {
                                min = timeL2[setbit][l]; }
                            t=l; }
                        for (k=0; k<L2E; k++) {
                            dataofL2[setbit][t]=current_data;
                            timeL2[setbit][t]++;
                            tagofL2[setbit][t]=as.substring(0,32-(L2b+L2s));
                        }
                    }break;} } }/////////////////

         System.out.println("I" + " " + operation_address.get(j)+","+ size.get(j));
         System.out.println("L1I:"+" " + MİSS_or_HIT +" "+ "L2:" +" "+ MİSS_or_HIT2);
         if(MİSS_or_HIT.equals("miss")&&MİSS_or_HIT2.equals("miss")){
             System.out.println("Place in L1I set" + setbitL1I +"," + "L2 set" + setbitL2I);
         }
         else if(MİSS_or_HIT.equals("miss")&&MİSS_or_HIT2.equals("hit")){
             System.out.println("Place in L1I set" + setbitL1I);
         }
         else if(MİSS_or_HIT.equals("hit")&&MİSS_or_HIT2.equals("miss")){
             System.out.println("Place in L2 set" + setbitL2I);
         }
         setbitL1I = 0;
         setbitL2I = 0;
         n=0;
    }
    else if (operation.get(j).equals("M")) {//önce data load sonra store işlemi
        hexdec = operation_address.get(j).toCharArray() ;
        hex2bin(hexdec);
        as = new String(output);
         for (i=(31-L1b); i>=(32-L1b-L1s); i--){
             if(L1s==0){
                 setbit=0;      }
             else{
                 setbitL1D += Math.pow(2,n)*Integer.parseInt(String.valueOf(output[i]));
                 n++;}
         }
         setbit = setbitL1D;
         hex = operation_address.get(j);
         decimal=Integer.parseInt(hex,16);

         for(int m=0; m<adress.size(); m++){
             if (m * BlockofsetofL1D == decimal) {
                 current_data = adress.get(m);
             }
         }
         for (k=0; k<L1E; k++) {
             if (tagofL1D[setbit][k].equals(as.substring(0, 32 - (L1b + L1s)))){
                 hit_L1D += 1;
                 MİSS_or_HIT = "hit";
             }
             else {
                 miss_L1D+=1;
                 MİSS_or_HIT = "miss";
                 for (k=0; k<L1E; k++) {
                     if ( vL1D[setbit][k] == 0){
                         dataofL1D[setbit][k]= current_data;
                         tagofL1D[setbit][k]=as.substring(0,32-(L1b+L1s));
                         vL1D[setbit][k]++;
                         timeL1D[setbit][k] ++;
                         break;
                     }
                     else {
                         eviction_L1D +=1;

                         int min = timeL1D[setbit][0];
                         for (l = 1; l < L1E; l++) {
                             if (timeL1D[setbit][l] < min) {
                                 min = timeL1D[setbit][l];
                             }
                             t=l;
                         }
                         for (k=0; k<L1E; k++) {
                             dataofL1D[setbit][t]=current_data;
                             timeL1D[setbit][t]++;
                             tagofL1D[setbit][t]=as.substring(0,32-(L1b+L1s));
                         }
                     }
                     break;
                 } } }/////////////////
         n = 0;
         for (i=(31-L2b); i>=(32-L2b-L2s); i--){
             if(L2s==0){
                 setbit=0;      }
             else{
                 setbitL2D += Math.pow(2,n)*Integer.parseInt(String.valueOf(output[i]));
                 n++;} }
         setbit = setbitL2D;

         hex= operation_address.get(j);
         decimal=Integer.parseInt(hex,16);
         for(int m=0; m<adress.size(); m++){
             if (m * BlockofsetofL2 == decimal) {
                 current_data = adress.get(m);
             } }
         for (k=0; k<L2E; k++) {
             if (tagofL2[setbit][k].equals(as.substring(0, 32 - (L2b + L2s)))){
                 hit_L2 += 1;
                 MİSS_or_HIT2 = "hit";  }
             else {
                 miss_L2+=1;
                 MİSS_or_HIT2 = "miss";
                 for (k=0; k<L2E; k++) {
                     if ( vL2[setbit][k] == 0){
                         dataofL2[setbit][k]= current_data;
                         tagofL2[setbit][k]=as.substring(0,32-(L2b+L2s));
                         vL2[setbit][k]++;
                         timeL2[setbit][k] ++;
                         break; }
                     else {
                         eviction_L2 +=1;
                         int min = timeL2[setbit][0];
                         for (l = 1; l < L2E; l++) {
                             if (timeL2[setbit][l] < min) {
                                 min = timeL2[setbit][l]; }
                             t=l; }
                         for (k=0; k<L2E; k++) {
                             dataofL2[setbit][t]=current_data;
                             timeL2[setbit][t]++;
                             tagofL2[setbit][t]=as.substring(0,32-(L2b+L2s));
                         } }
                     break;} } }/////////////////
         System.out.println("M" + " " + operation_address.get(j)+","+ size.get(j)+","+new_data.get(j));
         System.out.println("L1D:" +" "+ MİSS_or_HIT +" "+ "L2:" +" "+ MİSS_or_HIT2);
         if(MİSS_or_HIT.equals("miss")&&MİSS_or_HIT2.equals("miss")){
             System.out.println("Place in L1D set" + setbitL1D +"," + "L2 set" + setbitL2D);
         }
         else if(MİSS_or_HIT.equals("miss")&&MİSS_or_HIT2.equals("hit")){
             System.out.println("Place in L1D set" + setbitL1D);
         }
         else if(MİSS_or_HIT.equals("hit")&&MİSS_or_HIT2.equals("miss")){
             System.out.println("Place in L2 set" + setbitL2D);
         }
         setbitL1D = 0;
         setbitL2D = 0;
         n = 0;
         for (i=(31-L1b); i>=(32-L1b-L1s); i--){
             if(L1s==0){
                 setbit=0;      }
             else{
                 setbitL1S += Math.pow(2,n)*Integer.parseInt(String.valueOf(output[i]));
                 n++;}}
         setbit = setbitL1S;
         hex= operation_address.get(j);
         decimal=Integer.parseInt(hex,16);
         for(int m=0; m<adress.size(); m++){
             if (m * BlockofsetofL1I == decimal) {
                 current_data = adress.get(m);
             } }
         for (k=0; k<L1E; k++) {
             if (tagofL1I[setbit][k].equals(as.substring(0, 32 - (L1b + L1s)))){
                 hit_L1D += 1;
                 MİSS_or_HIT = "hit";
                 for (i=31; i>=(32-L1b); i--){
                     ofsetL1D += Math.pow(2,z)*Integer.parseInt(String.valueOf(output[i]));
                     z++; }
                 for(i=0; i<2*size.get(j); i++ ){
                     dataofL1D[setbit][k]=dataofL1D[setbit][k].replace(dataofL1D[setbit][k].charAt(ofsetL1D),new_data.get(j).charAt(i));
                     ofsetL1D += 1;}}
             else {
                 miss_L1D+=1;
                 MİSS_or_HIT = "miss";
             } }/////////////////
         ofsetL1D = 0;
         ofsetL2 = 0;
         n=0;
         z = 0;
         for (i=(31-L2b); i>=(32-L2b-L2s); i--){
             if(L2s==0){
                 setbit=0;      }
             else{
                 setbitL2S += Math.pow(2,n)*Integer.parseInt(String.valueOf(output[i]));
                 n++;} }
         setbit = setbitL2S;
         hex= operation_address.get(j);
         decimal=Integer.parseInt(hex,16);
         for(int m=0; m<adress.size(); m++){
             if (m * BlockofsetofL2 == decimal) {
                 current_data = adress.get(m);
             } }
         for (k=0; k<L2E; k++) {
             if (tagofL2[setbit][k].equals(as.substring(0, 32 - (L2b + L2s)))){
                 hit_L2 += 1;
                 MİSS_or_HIT2 = "hit";
                 for (i=31; i>=(32-L2b); i--){
                     ofsetL2 += Math.pow(2,z)*Integer.parseInt(String.valueOf(output[i]));
                     z++; }
                 for(i=0; i<2*size.get(j); i++ ){
                     dataofL2[setbit][k]=dataofL2[setbit][k].replace(dataofL2[setbit][k].charAt(ofsetL2),new_data.get(j).charAt(i));
                     ofsetL2 += 1;}
                 ofsetL2=0;
                 }
             else {
                 miss_L2+=1;
                 MİSS_or_HIT2 = "miss";
             } }/////////////////
         System.out.println("M" + " " + operation_address.get(j)+","+ size.get(j)+","+ new_data.get(j));
         System.out.println("L1D:" +" "+ MİSS_or_HIT +" "+ "L2:" +" "+ MİSS_or_HIT2);
         if(MİSS_or_HIT.equals("miss")&&MİSS_or_HIT2.equals("miss")){
             System.out.println("Place in L2 set" + setbitL2S +"," + "L1D set" + setbitL1S +","+"RAM");
         }
         else if(MİSS_or_HIT.equals("miss")&&MİSS_or_HIT2.equals("hit")){
             System.out.println("Place in L1D set" + setbitL1S+","+"RAM");
         }
         else if(MİSS_or_HIT.equals("hit")&&MİSS_or_HIT2.equals("miss")){
             System.out.println("Place in L1D set" + setbitL2S+","+"RAM");
         }

         ofsetL1D = 0;
         ofsetL2 = 0;
         n=0;
         z = 0;
         setbitL1S=0;
         setbitL2S=0;}
}
System.out.println(" ");
System.out.println("L1I-hits:" + hit_L1I+" " + "L1I-misses:" + miss_L1I+" " +"L1I-evictions:"+ eviction_L1I) ;
        System.out.println("L1D-hits:" + hit_L1D +" "+ "L1D-misses:" + miss_L1D +" "+"L1D-evictions:"+ eviction_L1D) ;
        System.out.println("L2-hits:" + hit_L2 +" "+ "L2-misses:" + miss_L2 +" "+"L2-evictions:"+ eviction_L2) ;
}//end of main
}
