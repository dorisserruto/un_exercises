#!/usr/bin/python
import sys
#FRECUENCIAS = ( ('AM',{540,1600},10.6),('FM',{88.1,108.1},0.2))

FREQUENCY_AM = range(5400,16000,106)
FREQUENCY_FM = range(881,1081,2)

MAX_AM = 106
MAX_FM = 100

def get_random_frequency(type):
	if (type == 'AM') or (type == 'am'):
		random_pos = random.randint(0,MAX_AM) 
		random_freq = FREQUENCY_AM[random_pos]*0.1
		print "%.1f" % random_freq
	elif (type == 'FM') or (type == 'fm'):
		random_pos = random.randint(0,MAX_FM) 
		random_freq = FREQUENCY_FM[random_pos]*0.01
		print "%.2f" % random_freq
	else:
		print 0

def random_stations(quantity,type):
	printed = 0
	while (printed < quantity + 1):
		get_random_frequency(type)
		printed+=printed

def main(argv):
print argv[1]
	random_stations(argv[1],argv[2])