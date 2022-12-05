import java.util.*;
public class Main {
static int lis(int arr[], int n)
{
SortedSet<Integer> hs = new TreeSet<Integer>();
for (int i = 0; i < n; i++)
hs.add(arr[i]);
int lis[] = new int[hs.size()];
int k = 0;
for (int val : hs) {
lis[k] = val;
k++;
}
int m = k, i, j;
int dp[][] = new int[m + 1][n + 1];
for (i = 0; i < m + 1; i++) {
for (j = 0; j < n + 1; j++) {
dp[i][j] = -1;
}
}
for (i = 0; i < m + 1; i++) {
for (j = 0; j < n + 1; j++) {
if (i == 0 || j == 0) {
dp[i][j] = 0;
}
else if (arr[j - 1] == lis[i - 1]) {
dp[i][j] = 1 + dp[i - 1][j - 1];
}
else {
dp[i][j]
= max(dp[i - 1][j], dp[i][j - 1]);
}
}
}
return dp[m][n];
}
public static void main(String[] args)
{
int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
int n = arr.length;
System.out.println("Length of lis is " + lis(arr, n)+ "\n");
}
}