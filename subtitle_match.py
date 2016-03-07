#Renames the video files as per srt filename
import os, sys, re
from glob import glob

def mv(src, dest):
    print 'mv "%s" "%s"' % (src, dest)
    #os.rename(src, dest)  # uncomment this to actually rename the files

dir = "C:\TV Series\Quantico"

vid_files = sorted(glob(os.path.join(dir, '*.mp4')))
sub_files = sorted(glob(os.path.join(dir, '*.srt')))
assert len(sub_files) == len(vid_files), "lists of different lengths"

for vidf, subf in zip(vid_files, sub_files):
    new_vidf = re.sub(r'\.srt$', '.mp4', subf)
    if vidf == new_vidf:
        print '%s OK' % ( vidf, )
        continue
    mv(vidf, new_vidf)
