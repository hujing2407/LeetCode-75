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