import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Main {
    public static ListNode deleteDuplicates(ListNode head) {

        if (head != null) {
            var headNoDuplicate = Arrays
                    .stream(head.toString().split(" -> "))
                    .distinct()
                    .collect(Collectors.joining());

            return factory(Integer.parseInt(headNoDuplicate));
        }

        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder buffer = new StringBuilder();
            ListNode current = this;
            while (current != null) {
                if (current != this) {
                    buffer.append(" -> ");
                }
                buffer.append(current.val);
                current = current.next;
            }
            return buffer.toString();
        }
    }

    public static void main(String... args) {
        test();
        test(1);
        test(1, 1);
        test(1, 1, 2);
        test(1, 1, 2, 2);
        test(1, 1, 2, 2, 2);
        test(1, 1, 2, 2, 2, 3, 3);
        test(1, 2, 3, 3);
        test(1, 2, 3, 3, 3, 4);
        test(1, 1, 3, 3, 3, 4, 4, 4);
        test(1, 2, 3, 4);
    }

    private static void test(int... values) {
        ListNode head = factory(values);
        System.out.printf("head: %s\n", head);
        System.out.printf("result: %s\n-------\n", deleteDuplicates(head));
    }

    private static ListNode factory(int... values) {
        return factory(Arrays.stream(values).iterator());
    }

    private static ListNode factory(Iterator<Integer> iterator) {
        if (iterator.hasNext()) {
            return new ListNode(iterator.next(), factory(iterator));
        }
        return null;
    }
}