#include <iostream>
using namespace std;
 
int main() {

    int m, n;

    cout <<"m="; cin>>m; 
    cout <<"n="; cin >>n;
    
    for (int i=0; i<n; i++) 
    {
        for (int j=0; j<m; j++)
            cout <<"* ";

            cout <<endl;
    }
    return 0;
}