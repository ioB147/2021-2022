#include<iostream>

using namespace std;
int main()
{
   int num, days, months, years;
   cout<<"Enter Number of Days: ";
   cin>>num;
   years = num/365;
   months = (num%365)/30;
   days = (num%365)%30;

   cout<<"Years: "<<years<<endl;
   cout<<"Months: "<<months<<endl;
   cout<<"Days: "<<days<<endl;
   cout<<endl;
   return 0;
}