#!/usr/bin/ruby
# -*- coding: UTF-8 -*-
require "FileUtils"

$NINE_PATCH_IMG = ".9.png"

current_dir = Dir::pwd

def traverse(path)
	if File.directory?(path)
		dir = Dir.open(path)
		while name = dir.read
			next if name =="."
			next if name ==".."
			traverse(path+"/"+name)
        end
	else
        puts path.to_s
		if path.to_s.include?$NINE_PATCH_IMG
			puts "delete file:"+path.to_s
			File.delete(path)
		end
	end
end

puts "traverse start"
traverse(current_dir)
puts "traverse finish!"
