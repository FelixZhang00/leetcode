#!/usr/bin/env python
#coding:utf-8

#这是leetcode上的一道题
#https://leetcode.com/problems/valid-number/

class Solution:
	def subzero(self,s):
		# print s,' in subzero'
		if len(s)>1 and s[0]=='0':
			for c in s:
				if c=='0':s=s[1:]	
		return s	

    # @param {string} s
    # @return {boolean}
	def isNumber(self, s):
		try:
			s=self.subzero(s)
			# print s
			eval(s)
			return True
		except:
			return False


def test():
	sol=Solution()
	print sol.isNumber('0008')
	print sol.isNumber('2e0')
	print sol.isNumber('e0')
	print sol.isNumber('0.')

if __name__=='__main__':test()