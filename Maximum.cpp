
// The external for allows to traverse the size minus one because it compares with the following position
// With a conditional it looks if the position it is in is greater than the following position
// If so, the elements are interchanged in position.
int Maximum(int* vector,int tam)
{
    int temp,mayor;
    for (int i = 0; i < tam - 1; i++) {
        for (int j = 0; j < tam - 1; j++) {
            if (vector[j] > vector[j + 1]) {
                // Allows swapping of values if they are in the wrong order
                temp = vector[j];
                vector[j] = vector[j + 1];
                vector[j + 1] = temp;
            }
        }
    }
        
    mayor= vector[tam-1];
         
    return mayor;
}   
