class Solution:
    def findLadders(self, beginWord, endWord, wordList):
        words = set(wordList)

        if endWord not in words:
            return []

        parents = {}
        level = {beginWord}
        found = False

        while level and not found:
            next_level = set()

            for word in level:
                for i in range(len(word)):
                    for c in "abcdefghijklmnopqrstuvwxyz":
                        new_word = word[:i] + c + word[i+1:]

                        if new_word in words:
                            next_level.add(new_word)
                            parents.setdefault(new_word, []).append(word)

                            if new_word == endWord:
                                found = True

            words -= next_level
            level = next_level

        if not found:
            return []

        result = []

        def build(word, path):
            if word == beginWord:
                result.append(path[::-1])
                return

            for parent in parents.get(word, []):
                build(parent, path + [parent])

        build(endWord, [endWord])

        return result