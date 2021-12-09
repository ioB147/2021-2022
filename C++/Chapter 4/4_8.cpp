#include <iostream>
#include <cmath>
using namespace std;

int main () {
    float quiz, midterm, finalscore, GPA;

    cout <<"Input quiz score: "; cin >>quiz;
    cout <<"Input mid-term score: "; cin >>midterm;
    cout <<"Input final score: "; cin >>finalscore;

    GPA=0.2*quiz + 0.3*midterm + 0.5*finalscore;
    cout <<"The grade point average= " <<GPA <<endl;
    if (GPA>8.5){
        cout<<"Grade A." <<endl;
    } else if (GPA>=7.0 && GPA<8.5){
         cout<<"Grade B." <<endl;
    } else if (GPA>=5.5 && GPA<7.0){
        cout<<"Grade C." <<endl;  
    } else if (GPA>=4.0 && GPA<5.5){
        cout<<"Grade D." <<endl;
    }else{
        cout<<"Grade F." <<endl;
    }
    return 0;
}