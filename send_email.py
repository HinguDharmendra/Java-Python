## Before running this, turn on the less secure access at 'https://www.google.com/settings/security/lesssecureapps'
## http://naelshiab.com/tutorial-send-email-python/

import smtplib
import time

localtime = time.asctime(time.localtime(time.time()))
t = localtime.split(' ')
d = t[2]+' '+t[1]+', '+t[4]

gmail_user = 'this.is@myEmail.com'
gmail_pwd = 'Pa55W0rd'

## Add all of your recipients to this txt file
f = open('recipients.txt', 'r+') 
bcc = f.readlines()

toaddr = 'this.is@friendEmail.com'
##add emails to people whom you want to keep in CC
cc = ['this.is@ccedEmail.com']
##add emails to people whom you want to keep in BCC
bcc = ['this.is@bccedEmail.com', 'this.is@bcced2Email.com']
fromaddr = 'dharmendra.hingu@live.com'
message_subject = 'Weekly Progress Report: ' + d 
message_text = '''

Dear User,

Type your message here.
Kindly send a quick status update on your activities:

1. How many Jira Tickets created so far?
2. How many Jira Tasks drafted last week?
3. How many Jira Tasks you have planned for this week?
4. How many Jira Tasks are pending?

Warm Regards,
Suitable Footer
'''

message = "From: %s\r\n" % fromaddr + "To: %s\r\n" % toaddr + "CC: %s\r\n" % ",".join(cc) + "Subject: %s\r\n" % message_subject + "\r\n" + message_text
toaddrs = [toaddr] + cc + bcc
server = smtplib.SMTP("smtp.gmail.com", 587)
#server.set_debuglevel(1) ##uncomment this to debug
server.ehlo()
server.starttls()
server.ehlo
server.login(gmail_user, gmail_pwd)
server.sendmail(fromaddr, toaddrs, message)
server.quit()
print 'sent!'
