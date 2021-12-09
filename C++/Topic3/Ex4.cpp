#include <iostream>
#include <string>
using namespace std;

int main() 
{
    string name, age, city, college, profession, animal, petsname;
    cout <<"Please enter your name: ";
    getline(cin, name);
    cout <<"Please enter your age: ";
    getline(cin,age);
    cout <<"Please enter your city: ";
    getline(cin,city);
    cout <<"Please enter your college: ";
    getline(cin,college);
    cout <<"Please enter your profession: ";
    getline(cin,profession);
    cout <<"Please enter the name of animal: ";
    getline(cin,animal);
    cout <<"Please enter the pet's name: ";
    getline(cin,petsname);
    cout <<"There once was a person named " <<name
         <<" who lived in " <<city
         <<". At the age of " <<age
         <<", " <<name
         <<" went to college at " <<college <<".";
}