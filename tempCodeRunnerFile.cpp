# include <bits/stdc++.h>
using namespace std;
void quicksort(int start, int end, int* arr)
{
    if (start >= end) return;
    int s = start;
    int e = end;
    int pivot = start + (end - start) / 2;
    while (s <= e)
    {
        while (arr[s] < arr[pivot]) s++;
        while (arr[e] > arr[pivot]) e--;
        if (s <= e)
        {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
    quicksort(start, e, arr);
    quicksort(s, end, arr);
}
void quicksort(int * arr , int n)
{
    quicksort(0 , n-1 , arr) ; 
}
void merge(int * arr , int start , int mid , int end )
{
    int * temp = new int[end-start+1] ; 
    int p1 = start ; 
    int p2 = mid+1 ; 
    int runner =0 ; 
    while(p1<=mid && p2<=end)
    {
       if(arr[p1]<arr[p2])
       {
        temp[runner] = arr[p1] ; 
        p1++ ; 
       }
       else
       {
        temp[runner] = arr[p2] ;
        p2++ ; 
       }
       runner++ ; 
    }
    while(p1<=mid)
    {
        temp[runner] = arr[p1] ; 
        p1++ ; runner++ ; 
    }
    while(p2<=end)
    {
        temp[runner] = arr[p2] ; 
        p2++ ; runner++ ;
    }
    for (int i = 0; i < runner; i++)
    {
        arr[start + i] = temp[i];
    }
    delete[] temp;
}

void heapify(int*arr , int n , int i )
{
    int largest =i ; 
    int left = 2*i +1 ;
    int right = 2*i + 2; 
    if(left<n && arr[left]>arr[largest]) largest = left ; 
    if(right<n && arr[right]>arr[largest])largest = right ; 
    if(largest!=i)
    {
        swap(arr[i] , arr[largest]) ; 
        heapify(arr , n , largest) ; 
    } 
     
}
void heapsort(int*arr , int n )
{
    for(int i = n/2-1 ; i>=0 ; i--)
    {
      heapify(arr , n , i) ; 
    }
    for(int i = n-1 ; i>0 ; i--)
    {
        swap(arr[i] , arr[0]) ; 
        heapify(arr , i , 0 ) ; 
    }
}
void mergesort(int *arr, int start, int end)
{
    if (start >= end)
        return;
    int mid = (start + end) / 2;
    mergesort(arr, start, mid);
    mergesort(arr, mid + 1, end);
    merge(arr, start, mid, end);
}

void mergesort(int *arr, int n)
{
    mergesort(arr, 0, n - 1);
}

vector<int> dfsOfGraph(int V, vector<int> adj[]) {
    vector<int> dfs; 
    stack<int> st; 
    vector<bool> visited(V, false); 
    st.push(0); 
    while (!st.empty()) {
        int node = st.top(); 
        st.pop(); 
        if (!visited[node]) {
            dfs.push_back(node); 
            visited[node] = true; 
            reverse(adj[node].begin() , adj[node].end()) ;
            for (int i = 0; i < adj[node].size(); i++) {
                if (!visited[adj[node][i]]) {
                    st.push(adj[node][i]); 
                }
            }
        }
    }
    return dfs;
}


int main() {
    int V = 10;
    vector<int> adj[V];
    int edges = 13;
    int edgeList[13][2] = {{0, 1}, {0, 2}, {0, 4}, {0, 8}, {1, 5}, {1, 6}, {1, 9},
                           {2, 4}, {3, 7}, {3, 8}, {5, 8}, {6, 7}, {6, 9}};

    for (int i = 0; i < edges; i++) {
        adj[edgeList[i][0]].push_back(edgeList[i][1]);
        adj[edgeList[i][1]].push_back(edgeList[i][0]);
    }

    vector<int> result = dfsOfGraph(V, adj);

    cout << "DFS traversal: ";
    for (int i : result) {
        cout << i << " ";
    }
    int arr[10] = {1,5,3,4,7,8,9,2,6,0} ; 
    heapsort(arr,10) ; cout<<endl ; 
    for(int i : arr) cout<<i<<" " ;
    return 0;
}










