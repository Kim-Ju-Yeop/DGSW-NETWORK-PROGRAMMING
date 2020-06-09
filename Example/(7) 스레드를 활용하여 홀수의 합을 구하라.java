package class05_26;

public class OddSum implements Runnable {
    public static void main(String[] args) {
        OddSum oddSum = new OddSum();
        oddSum.run();
    }

    @Override
    public void run() {
        int i = 1, sum = 0;
        while(i <= 1000){
            if(i % 2 != 0) sum += i;
            i++;
        }
        System.out.println("1~1000 홀수의 합계 : " + sum);
    }
}
