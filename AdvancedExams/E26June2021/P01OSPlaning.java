package JavaAdvanced.AdvancedExams.E26June2021;

import java.util.*;

public class P01OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> taskStack = new ArrayDeque<>();
        int threadThatKillsTask = 0;

        for (Integer integer : input){
            taskStack.push(integer);
        }
        input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (Integer integer : input){
            threadsQueue.offer(integer);
        }
        int taskToKill = Integer.parseInt(scanner.nextLine());

        while (!taskStack.isEmpty() && !threadsQueue.isEmpty()){
            int firstThread = threadsQueue.peek();
            int lastTask = taskStack.peek();
            if(lastTask == taskToKill){
                threadThatKillsTask = firstThread;
                break;
            }
            if(firstThread >= lastTask){
                threadsQueue.poll();
                taskStack.pop();
            }else {
                threadsQueue.poll();
            }
        }
        System.out.printf("Thread with value %d killed task %d\n", threadThatKillsTask, taskToKill);
        threadsQueue.forEach(thread -> System.out.print(thread + " "));
    }
}
