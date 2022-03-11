import numpy as np
from keras.models import load_model

from keras.preprocessing.image import img_to_array

import cv2
import numpy as np

import glob
import pandas as pd



def get_data(video):
    # if list of video
    # make this opration number of video
            # 1 split it to many video list of entrval
            #  function retrun list of videos [0:10],[10:15],[15,20] list_video_child_one
            #  loop take in every time one item
            # 2 every singel elemnt in list_video_child_one and split it to list_video_child_two [0:10]-> to list every item have video 10s
            # 3 take list from from 2 and convert every item to 7 fram return list of images for all list  list_video_child_two
            # 4 get list of all image for every spacfic range
            # 5 make two thing extract (emtion and eye diraction)
            # 6 now i have list of image for first range and two list (emotion and eye diraction )
            # put in the model and get the result
            # repeet it number of entrval
    
    return 0