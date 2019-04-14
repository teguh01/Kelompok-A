import numpy as np
import cv2
wajah = cv2.CascadeClassifier('haarcascade_smile.xml')
 
image = cv2.imread('org1.jpg')
grayImage = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
 
wajahManusia = wajah.detectMultiScale(grayImage)
 
print type(wajahManusia)
 
if len(wajahManusia) == 0:
    print "No faces found"
 
else:
    print wajahManusia
    print wajahManusia.shape
    print "Jumlah Deteksi Wajah: " + str(wajahManusia.shape[0])
 
    for (x,y,w,h) in wajahManusia:
        cv2.rectangle(image,(x,y),(x+w,y+h),(0,255,0),1)
 
    cv2.rectangle(image, ((0,image.shape[0] -25)),(270, image.shape[0]), (255,255,255), -1)
    cv2.putText(image, "Jumlah Deteksi Wajah: " + str(wajahManusia.shape[0]), (0,image.shape[0] -10), cv2.FONT_HERSHEY_TRIPLEX, 0.5,  (0,0,0), 1)
 
    cv2.imshow('Image with faces',image)
    cv2.waitKey(0)
    cv2.destroyAllWindows()
