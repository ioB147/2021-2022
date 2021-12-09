#include <iostream>
using namespace std;

int find(int x, int y);

int main(){
    int n,m;
    cout<<"n= "; cin >> n; cout <<"m= "; cin >> m;

    find(n,m);
    return 0;
}

int find(int x, int y){
    int out=0;
    int max=0;
    if (x > y)
    {
        cout<<"F";
    }
    else if (x < y) 
    {
    for (int i = x; i<=y; i++)
    {
        int term=0;
        int a=i;
        while (a!=0)
        {
            term+=a%10;
            a/=10;
        }
        if (term>=max)
        {
            max=term;
            out=i;
        }
    }
        return out;
    }
}