// ADC.c
// Program to use ADC to read variable resistor input and display on LEDs
// For project using USB interface with Bootloader


/*
 *	Perform 10-bit a2d on RA0/AN0 through Trimmer R16
 *	Output result on PORTD 
 *	
 *	Makes use of repetitive for-loop to convert the 
 *	analog value at RA0/AN0 to a 10-bit result.
 *
 *      Makes use of the ADRESH result to detect a user setting
 *      eg a temperature setting for a thermostat (TempTrip)
 *      
 *      Note that the time between each conversion will be
 *	longer as more user code are inserted.
 */
#include <stdio.h>
#include <xc.h>
#include "delays.h"
#include "lcd.h"	
unsigned char key,outchar,ADC_value, outchar2;
char Message1 [ ] = "Rain Sensor :  ";	  // Defining a 20 char string
char Message2 [ ] = "Clear weather :  ";	  
char Message3 [ ] = " Light Rain:  ";
char Message4 [ ] = " Raining:  ";
char Message5 [ ] = " Raining heavily:  ";

	  
char buffer[20];
int i=0;

void onetone(void) //Function to generate one tone
{
    unsigned int k;

    for (k = 0; k < 100; k++) //Determines duration of tone
    {
        delay_us(3000);  // useable values from 100  to 5000
        PORTCbits.RC0 = !PORTCbits.RC0; //Invert logic level at RC0
    }
}
void main(void)
{
    
    
	lcd_init();						// Initialise LCD module

	
		lcd_write_cmd(0x80);			// Move cursor to line 1 position 1
		//for (i = 0; i < 20; i++)		//for 20 char LCD module
        for (i=0;Message1[i]!=0;i++)
		{
			outchar = Message1[i];
			lcd_write_data(outchar); 	// write character data to LCD
		}
	
	
    
	#define HIGH 0xF0   //255-240 - Clear Weather 
	#define MID 0XA0   //239-160 - Light Rain
	#define LOW 0x64     //159-80 - Raining
	#define VERYLOW 0X00   //79-0 - Heavy Rain


	TRISD = 0x00;		// Set PORTD to be output
	PORTD = 0x00;		// Initialise PORTD LEDs to zeros

	TRISCbits.TRISC1 = 0; 	// RC1 as output pin
 	PORTCbits.RC1    = 0;   // RC1 is connected to Relay

	TRISCbits.TRISC2 = 0; 	// RC2 as output pin
 	PORTCbits.RC2    = 0;   // RC2 is connected to Motor

	/* Initialise analog to digital conversion setting */

	ADCON0 = 0b00000001;    // bit5-2 0000 select channel 0 conversion 
							// bit1	  A/D conversion status bit
							//	      1- GO to starts the conversion
							//	      0 - DONE when A/D is completed
							// bit0   Set to 1 to power up A/D

	ADCON1 = 0b00001100;	// bit5   reference is VSS
							// bit4   reference is VDD
							// bit3-0 AN2 to AN0 Analog, the rest Digital

	ADCON2 = 0b00010110;	// bit7   : A/D Result Format. 0 Left, 1 Right justified
							// bit5-3 : 010 acquisition time = 4 TAD
							// bit2-0 : 110 conversion clock = Tosc / 16
    
    TRISCbits.TRISC0 = 0; //-- Set RC0 as output

	while(1)
	{
		ADCON0bits.GO = 1;		// This is bit2 of ADCON0, START CONVERSION NOW
	        
		while(ADCON0bits.GO == 1); 	// Waiting for DONE 
			
        //ADRESH output of the conversion is in 8 bit binary... eg: 1111 1111
		
		if(ADRESH> HIGH && ADRESH < 256) //=============================================================0xf0 >240
        {						//==================== LCD ==============================================//

								lcd_write_cmd(0x80);			                // Move cursor to line 2 position 1
									  
								for (i=0;Message2[i]!=0;i++)                    //output array buffer 
									  {
										  outchar = Message2[i];
										  lcd_write_data(outchar); 	            // write character data to LCD - Clear Weather
									  }
									  
								sprintf(buffer,"Sensor value:  %d ", ADRESH);
									  
								lcd_write_cmd(0xC0);			               // Move cursor to line 2 position 1
									  
								for (i=0;buffer[i]!=0;i++)                     //output array buffer 
									  {
										  outchar = buffer[i];
										  lcd_write_data(outchar); 	           // write character data to LCD
									  }
		}
		else if(HIGH >ADRESH && ADRESH> MID) //=========================================0XA0 240> ADRESH >160
		{
								//==================== LCD ==============================================//
								
								  lcd_write_cmd(0x80);	                        // Move cursor to line 2 position 1
								  
								  for (i=0;Message3[i]!=0;i++)                 //output array buffer 
								  {
									  outchar = Message3[i];
									  lcd_write_data(outchar); 	               // write character data to LCD - Light Rain
								  }
								  
								  sprintf(buffer,"Sensor value:  %d ", ADRESH);
								  
								  lcd_write_cmd(0xC0);			               // Move cursor to line 2 position 1
								  
								  for (i=0;buffer[i]!=0;i++)                   //output array buffer 
								  {
									  outchar = buffer[i];
									  lcd_write_data(outchar); 	               // write character data to LCD
								  }
              
								  //=================== buzzer ==========================================//
								  {
									onetone(); //sound ON then OFF
									PORTCbits.RC0=0;

									delay_ms(500);

									onetone(); //sound ON then OFF
									PORTCbits.RC0=0;
									delay_ms(3000);
									
									onetone(); //sound ON then OFF
									PORTCbits.RC0=0;

									delay_ms(500);

									onetone(); //sound ON then OFF
									PORTCbits.RC0=0;
									delay_ms(3000);
 
									
								  }
		}
		else if(ADRESH> LOW && ADRESH <MID)  //=========================================0x50  160> ADRESH >80 
		{						
								//==================== LCD ==============================================//
								
								  lcd_write_cmd(0x80);	                        // Move cursor to line 2 position 1
								  
								  for (i=0;Message4[i]!=0;i++)                 //output array buffer 
								  {
									  outchar = Message4[i];
									  lcd_write_data(outchar); 	               // write character data to LCD - Raining 
								  }
								  
								  sprintf(buffer,"Sensor value:  %d ", ADRESH);
								  
								  lcd_write_cmd(0xC0);			               // Move cursor to line 2 position 1
								  
								  for (i=0;buffer[i]!=0;i++)                   //output array buffer 
								  {
									  outchar = buffer[i];
									  lcd_write_data(outchar); 	               // write character data to LCD
								  }
              
								  //=================== buzzer ==========================================//
								  {
									onetone(); //sound ON then OFF
									PORTCbits.RC0=0;

									delay_ms(500);

									onetone(); //sound ON then OFF
									PORTCbits.RC0=0;
									delay_ms(2000);
									
									onetone(); //sound ON then OFF
									PORTCbits.RC0=0;

									delay_ms(500);

									onetone(); //sound ON then OFF
									PORTCbits.RC0=0;
									delay_ms(2000);
                                    
                                    onetone(); //sound ON then OFF
									PORTCbits.RC0=0;

									delay_ms(500);

									onetone(); //sound ON then OFF
									PORTCbits.RC0=0;
									delay_ms(3000);
									
									onetone(); //sound ON then OFF
									PORTCbits.RC0=0;

									delay_ms(500);

									onetone(); //sound ON then OFF
									PORTCbits.RC0=0;
									delay_ms(3000);
 
									
								  }
		
		}
		else   //========================================================================0X00     80> ADRESH >0x00
		{
								//==================== LCD ==============================================//
								
								  lcd_write_cmd(0x80);	                        // Move cursor to line 2 position 1
								  
								  for (i=0;Message5[i]!=0;i++)                 //output array buffer 
								  {
									  outchar = Message5[i];
									  lcd_write_data(outchar); 	               // write character data to LCD - Raining Heavily
								  }
								  
								  sprintf(buffer,"Sensor value:  %d ", ADRESH);
								  
								  lcd_write_cmd(0xC0);			               // Move cursor to line 2 position 1
								  
								  for (i=0;buffer[i]!=0;i++)                   //output array buffer 
								  {
									  outchar = buffer[i];
									  lcd_write_data(outchar); 	               // write character data to LCD
								  }
              
								  //=================== buzzer ==========================================//
								  {
									onetone(); //sound ON then OFF
									PORTCbits.RC0=0;

									delay_ms(500);

									onetone(); //sound ON then OFF
									PORTCbits.RC0=0;
									delay_ms(100);
									
									onetone(); //sound ON then OFF
									PORTCbits.RC0=0;

									delay_ms(500);

									onetone(); //sound ON then OFF
									PORTCbits.RC0=0;
									delay_ms(100);
                                    
                                    onetone(); //sound ON then OFF
									PORTCbits.RC0=0;

									delay_ms(500);

									onetone(); //sound ON then OFF
									PORTCbits.RC0=0;
									delay_ms(100);
									
									onetone(); //sound ON then OFF
									PORTCbits.RC0=0;

									delay_ms(500);

									onetone(); //sound ON then OFF
									PORTCbits.RC0=0;
									delay_ms(100);
                                    
                                    onetone(); //sound ON then OFF
									PORTCbits.RC0=0;

									delay_ms(500);

									onetone(); //sound ON then OFF
									PORTCbits.RC0=0;
									delay_ms(100);
									
									onetone(); //sound ON then OFF
									PORTCbits.RC0=0;

									delay_ms(500);

									onetone(); //sound ON then OFF
									PORTCbits.RC0=0;
									delay_ms(100);
 
									
								  }
		}
    }
}