#include <stdio.h>

int main(){
    int x=1;
    x+=1;
    printf("%d", x);
    int y=++x + x++;
    
    printf("%d", y);
    
    float f=3*y/2;

    printf("%f", f);


    return 0;
}