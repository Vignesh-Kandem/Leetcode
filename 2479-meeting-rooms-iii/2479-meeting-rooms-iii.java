import java.util.*;
public class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>((a, b) ->
            a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1])
        );
        int[] roomMeetingCount = new int[n];
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                availableRooms.offer((int) busyRooms.poll()[1]);
            }
            if (!availableRooms.isEmpty()) {
                int room = availableRooms.poll();
                roomMeetingCount[room]++;
                busyRooms.offer(new long[]{start + duration, room});
            } else {
                long[] earliest = busyRooms.poll();
                long newStart = earliest[0];
                int room = (int) earliest[1];
                roomMeetingCount[room]++;
                busyRooms.offer(new long[]{newStart + duration, room});
            }
        }
        int maxMeetings = 0, resultRoom = 0;
        for (int i = 0; i < n; i++) {
            if (roomMeetingCount[i] > maxMeetings) {
                maxMeetings = roomMeetingCount[i];
                resultRoom = i;
            }
        }
        return resultRoom;
    }
}