#include <iostream>
using namespace std;
 

int candyParcel(int nSmall, int nBig, int req) {
    if (nSmall * 2 + nBig * 5 < req) return -1;
    while (nBig*5 > req) 
    {
        nBig--;
    }
    int ans = (req-nBig*5);
    if (ans % 2 != 0) return -1;
    ans /= 2;
    if (ans > nSmall) return -1;
    return ans;
}

int main() 
{
    int nSmall, nBig, req;

    cout <<"Number of small: ";
    cin >> nSmall;
    cout <<"Number of big: ";
    cin >> nBig;
    cout <<"parcel order: ";
    cin >>req;

    cout <<"Required number of small candies= " <<candyParcel(nSmall,nBig,req);
    
    return 0;
}