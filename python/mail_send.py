#-*- coding:utf-8 -*-

from email.mime.text import MIMEText
from email.mime.application import MIMEApplication
from email.header import Header
from email.utils import parseaddr,formataddr
from email.mime.multipart import MIMEMultipart
import  smtplib
import os

from_addr = ''
password  = ''
smtp_server = 'smtp.163.com'
smtp_port = 25

def send_mail(message):
    server = smtplib.SMTP(smtp_server, smtp_port)
    server.set_debuglevel(1)
    server.login(from_addr, password)

    lto, lcc, lbcc = [], [], []
    lto = message['To'].split(',')
    if message['Cc'] is not None:
        lcc = message['Cc'].split(',')
    if message['Bcc'] is not None:
        lbcc = message['Bcc'].split(',')
    recevers = lto + lcc + lbcc
    server.sendmail(from_addr, recevers, message.as_string())
    server.quit()

def construct_mimetext_message(subject,text,subtype,to,cc=None,bcc=None):
    message = MIMEText(text, _subtype=subtype, _charset='utf-8')
    message['From'] = from_addr
    message['To'] = to
    message['Cc'] = cc
    message['Bcc'] = bcc
    message['Subject'] = Header(subject, 'utf-8').encode()
    return  message


def send_plain_mail(subject,text,to,cc=None,bcc=None):
    message = construct_mimetext_message(subject,text,'plain',to,cc,bcc)
    send_mail(message)

def send_html_mail(subject,text,to,cc=None,bcc=None):
    message = construct_mimetext_message(subject, text, 'html', to, cc, bcc)
    send_mail(message)


def send_attachment_mail(subject,text,paths,to,cc=None,bcc=None):
    """
    :param subject: 邮件主题
    :param text: 邮件正文
    :param paths: 附件全路径 list[tuple]
    :param to:
    :param cc:
    :param bcc:
    :return:
    """
    composite_message = MIMEMultipart()
    composite_message['From'] = from_addr
    composite_message['To'] = to
    composite_message['Cc'] = cc
    composite_message['Bcc'] = bcc
    composite_message['Subject'] = Header(subject, 'utf-8').encode()

    text_message = MIMEText(text,'plain','utf-8')
    composite_message.attach(text_message)

    for path,name in paths:
        with open(path,'rb') as r:
            attachment_message = MIMEApplication(r.read())
            attachment_message.add_header('Content-Disposition', 'attachment', filename=name)
            composite_message.attach(attachment_message)

    send_mail(composite_message)


if __name__ == '__main__':
    root_path = '/Users/jackwang/Desktop/'
    c = [os.path.join(root_path,file) for file in os.listdir(root_path) if file.endswith('.jpg')]

    paths = []
    for path in c:
        paths.append((path,os.path.split(path)[1]))

    send_attachment_mail('AttachmentMail','this is an attachment mail',paths,'xxxxx@qq.com')




