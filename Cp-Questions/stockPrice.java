Given a stock prices you need to design prices list such that the absolute difference of the starting day price and ending day price should be minimum
and while doing this care should be taken that remaining prices should actually fluctuate in increase decrease fashion only,
and not mandatory for last two day's prices it has choice it may or may not obey fluctuate constraint. Given that all the stock prices are unique.

Examples : 

Input : 9 1 8 2  // Stock prices

OutPut : 1 8 9 2




// C++ code for the Solution by Sharath-Majjigi
#include <bits/stdc++.h>
using namespace std;

//Function to arrange the prices
void arrangePrices(int n, int a[])
{
    // Sort the given prices
    sort(a, a + n);
    // variables to hold the locations of pair whose abs
    // difference is minimum
    int pf = 0; // pf = in pair first price
    int ps = 1; // ps = in pair second price

    int diff = abs(a[ps] - a[pf]);
    for (int i = 1; i < n - 1; i++) {
        // Checking for every consecutive pair and storing
        // the locations of minimum abs difference
        if (a[i + 1] - a[i] < diff) {
            diff = abs(a[i + 1] - a[i]);
            pf = i;
            ps = i + 1;
        }
    }
    // Fix the first day price
    cout << a[pf] << " ";
    // Rest of the day's prices which follows the constraint
    for (int i = ps + 1; i < n; i++)
        cout << a[i] << " ";

    for (int i = 0; i < pf; i++)
        cout << a[i] << " ";

    // Fix the last day's Price
    cout << a[ps] << "\n";
}

// Driver Code
int main()
{
    int n = 5;
    int a[5] = { 5, 7, 9, 5, 8 };
    arrangePrices(n, a);
    return 0;
}
