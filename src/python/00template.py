# dfs
visited =  set()

def dfs(node,visited):
    if node in visited: # terminator
        # already visited
        return
    visited.add(node)
    # process current node here
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node,visited)

def DFS(self,tree): # non-recursive version, using stack
    if tree.root is None:
        return []
    visited,stack = [],[tree.root]
    while stack:
        node = stack.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        stack.push(node)
        # other processing work

# BFS
def BFS(graph,start,end):
    queue = []
    queue.append(start) 
    visited.add(start)

    while queue:
        node = queue.pop()
        visited.add(node)
        process(node)
        nodes = generate_related_nodes(node)
        queue.push(node)