#include<iostream>
#define PI 3.1416

using namespace std;
int main()
{  
    int a,b;
    cout <<"Input the height and width of rectangle= ";
    cin >>a >>b;
    cout <<"The perimeter= " <<(a+b)*2 <<endl;
    cout <<"The area= " <<(a*b) <<endl;
    return 0;
}