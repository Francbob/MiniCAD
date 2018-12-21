import os
import cv2

for img in [x for x in os.listdir('.') if os.path.isfile(x) and os.path.splitext(x)[1]=='.jpg']:
    if img != 'a.py':
        print(img)
        i = cv2.imread(os.path.join('.', img))
        i = cv2.resize(i,(25,25))
        cv2.imwrite(img,i)