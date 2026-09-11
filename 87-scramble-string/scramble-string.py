class Solution:
    def isScramble(self, s1, s2):
        memo = {}

        def solve(a, b):
            if (a, b) in memo:
                return memo[(a, b)]

            if a == b:
                return True

            if len(a) != len(b):
                return False

            if sorted(a) != sorted(b):
                return False

            n = len(a)

            for i in range(1, n):
                # No swap
                if solve(a[:i], b[:i]) and solve(a[i:], b[i:]):
                    memo[(a, b)] = True
                    return True

                # Swap
                if solve(a[:i], b[n-i:]) and solve(a[i:], b[:n-i]):
                    memo[(a, b)] = True
                    return True

            memo[(a, b)] = False
            return False

        return solve(s1, s2)
        