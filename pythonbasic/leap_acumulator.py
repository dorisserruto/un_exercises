#!/usr/bin/python

import datetime

def getSumLeap():
	sumLeaps = 0
	today = datetime.date.today()
	proposed_leaps = range(0,today.year,4)
	for prop_leap in proposed_leaps:
		if isLeap(prop_leap):
			sumLeaps+= prop_leap

def isLeap(year):
	if (year % 100 > 0): #no divisible
		return True
	elif (year % 400 > 0):
		return True
	else:
		return False

#def main(argv):
getSumLeap()
raw_input()