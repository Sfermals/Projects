
#include <xc.h>
#include "delays.h"
#include "lcd.h"	
unsigned char key,outchar;
char Message1 [ ] = "Enter PIN number :  ";	  // Defining a 20 char string

// ---- Main Program ---------------------------------------------------------------
void main1(void)
{
	int i;
	lcd_init();						// Initialise LCD module

	while(1)
	{
		lcd_write_cmd(0x80);			// Move cursor to line 1 position 1
		for (i = 0; i < 20; i++)		//for 20 char LCD module
		{
			outchar = Message1[i];
			lcd_write_data(outchar); 	// write character data to LCD
		}
	
	}
}




