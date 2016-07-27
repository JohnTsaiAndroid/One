#!/usr/bin/ruby
# -*- coding: UTF-8 -*-
require "FileUtils"

$NINE_PATCH_IMG = ".9.png"

current_dir = Dir::pwd

def traverse(path)
	puts "traverse start"
	if File.directory?(path)
		dir = Dir.open(path)
		while name = dir.read
			next if name =="."
			next if name ==".."
			traverse(path+"/"+name)
		end
	else
		if path.to_s.include?$NINE_PATCH_IMG
			puts "delete file:"+path.to_s
			File.delete(path)
		end
	end
	puts "traverse finish!"
end

traverse(current_dir)
