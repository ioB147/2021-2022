#include <iostream>
using namespace std;

int main()
{
    float s,f;
    cout <<"What is that actual value of a property? $";
    cin >> s;
    f=s*0.6;
    cout <<"-The assessment value of property= $" <<f <<endl;
    cout <<"-The property tax of the assessment value= $" <<(f*75)/10000 <<endl;
    return 0;
}