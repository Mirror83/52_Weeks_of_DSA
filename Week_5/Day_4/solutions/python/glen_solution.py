

class Node(object):
    def __init__(self, data=None):
        self.data = data
        self.next = None


def sorted_merge(first, second):
    """
    Time complexity: O(len(first) + len(second))
    Space complexity: O(1) (excluding the length of the result 
    list which is len(first) + len(second))
    """
    if first is None:
        return second
    if second is None:
        return first

    result = None
    current_result = None

    current_first = first
    current_second = second

    while current_first is not None and current_second is not None:
        val = None
        if current_first.data <= current_second.data:
            val = current_first.data
            current_first = current_first.next
        else:
            val = current_second.data
            current_second = current_second.next

        if result == None:
            result = Node(val)
            current_result = result
        else:
            current_result.next = Node(val)
            current_result = current_result.next

    # The following two loops handle whichever list where the
    # elements were not all input into the result list
    # (i.e the elements that were larger than
    # the largest element in one  of the lists.)
    # Only one of this loops will run at runtime

    while current_first is not None:
        current_result.next = Node(current_first.data)
        current_first = current_first.next
        current_result = current_result.next

    while current_second is not None:
        current_result.next = Node(current_second.data)
        current_second = current_second.next
        current_result = current_result.next

    return result
