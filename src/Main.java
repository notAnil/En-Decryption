import  java.util.*;
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<ArrayList<Integer>> code = new ArrayList<>();
    private static String[] holder;
    private static ArrayList<ArrayList<ArrayList<Integer>>> behold = new ArrayList<>();

    public static String shuffler(String parts){

        parts = parts.toLowerCase(Locale.ROOT);
        String [] res= new String[parts.length()];
        for(int i = 0; i<parts.length();i++){
            res[i]=parts.substring(i,i+1);
        }
        int start =0;
        int end=-1;
        for (int j=0;j<res.length;j++){

            if(res[j].equals(" ")||j==res.length-1){
                start = end+1;
                end=j;
                shuffleHelper(start,end,res);
            }

        }
        holder =res;
        String fin="";
        for(int k=0;k<res.length;k++){
            fin+=res[k];
        }
        System.out.println(code);
        return fin;
    }
    public static void shuffleHelper(int start, int end, String [] help){
        int ran = 0;

        for (int i=start; i<end;i+=ran+2){          //if you increase the sum between ran and the integer it will be less random
            ran =(int)(Math.random()*(end-start));  //but il will effect the shorter words less
            String temp = help[i];
            help[i] = help[start+ran];
            help[start+ran]=temp;
            ArrayList<Integer> begone = new ArrayList<Integer>(2);
            begone.add(i);
            begone.add(ran+start);
            code.add(begone);
        }

    }
    public static String encrypter(String parts){
        parts = parts.toLowerCase(Locale.ROOT);
        String [] res= new String[parts.length()];
        for(int i = 0; i<parts.length();i++){
            res[i]=parts.substring(i,i+1);
        }
        int ran=0;
        for (int i=0; i<res.length;i+=ran+2) {          //if you increase the sum between ran and the integer it will be less random
            ran = (int) (Math.random() * (res.length));  //but il will effect the shorter words less
            String temp = res[i];
            res[i] = res[ran];
            res[ran] = temp;
            ArrayList<Integer> begone = new ArrayList<Integer>(2);
            begone.add(i);
            begone.add(ran);
            code.add(begone);
        }

        //holder =res;  no need to this anymore
        String fin="";
        for(int k=0;k<res.length;k++){
            fin+=res[k];
        }
        System.out.println(code);
        return fin;
    }
   /* public static String deshuffler(){ //update
        String res="";
        for (int i = code.size()-1;i>=0;i--){
            String temp = holder[code.get(i).get(1)];
            holder[code.get(i).get(1)]= holder[code.get(i).get(0)];
            holder[code.get(i).get(0)]=temp;
        }
        for (int j =0;j< holder.length;j++){
            res+=holder[j];
        }
        return res;
    }*/
    public static void makeAChoice(){
        System.out.println("what do you want?(Encryption or decryption)");
        String gir= sc.nextLine();
        gir=gir.toLowerCase(Locale.ROOT);
        if(gir.equals("encryption")){
            System.out.println("What is it to shuffle");
            String parts = sc.nextLine();
            System.out.println("How many times?");
            int n = sc.nextInt();

            System.out.println(doItAgain(n,parts));
        } /*else if (gir.equals("decryption")){
            System.out.println(shuffler());
            System.out.println(deshuffler());
        }*/

    }
    public static String doItAgain(int n, String value){
        String res = value;
        for (int i=0;i<n;i++){
            res = encrypter(res);
            record();
        }
        System.out.println(behold);
        return res;
    }
    public static void record(){

        behold.add(code);
        code = new ArrayList<>();

    }
    public static void main(String[] args) {
        makeAChoice();

    }
}