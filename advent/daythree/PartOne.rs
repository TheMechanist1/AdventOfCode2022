use std::{
    fs::File,
    io::{prelude::*, BufReader},
    path::Path,
};

//Part One
fn lines_from_file(filename: impl AsRef<Path>) -> Vec<String> {
    let file = File::open(filename).expect("no such file");
    let buf = BufReader::new(file);
    buf.lines()
        .map(|l| l.expect("Could not parse line"))
        .collect()
}

fn divide_string_half(string: &str) -> (String, String) {
    let half = string.len() / 2;
    let (left, right) = string.split_at(half);
    (left.to_string(), right.to_string())
}

fn get_duplicate_characters(string: &str) -> Vec<char> {
    let mut left_characters: Vec<char> = Vec::new();
    let mut right_characters: Vec<char> = Vec::new();
    let (left, right) = divide_string_half(string);
    for character in left.chars() {
        left_characters.push(character);
    }
    for character in right.chars() {
        right_characters.push(character);
    }
    let mut duplicate_characters: Vec<char> = Vec::new();
    for character in left_characters {
        if right_characters.contains(&character) {
            if !duplicate_characters.contains(&character) {
                duplicate_characters.push(character);
            }
        }
    }
    duplicate_characters
    
}

fn map_char_score_lowercase(characters: &Vec<char>) -> Vec<i32> {
    let mut scores: Vec<i32> = Vec::new();
    for character in characters {
        if character.is_lowercase() {
            scores.push(*character as i32 - 96);
        } else {
            scores.push(*character as i32 - (64-26));
        }
    }
    scores
}
//Part One

//Part Two
fn divide_lines_into_groups_of_three(lines: &Vec<String>) -> Vec<(String, String, String)> {
    let mut groups: Vec<(String, String, String)> = Vec::new();
    let mut group: (String, String, String) = ("".to_string(), "".to_string(), "".to_string());
    for (index, line) in lines.iter().enumerate() {
        if index % 3 == 0 {
            group.0 = line.to_string();
        } else if index % 3 == 1 {
            group.1 = line.to_string();
        } else if index % 3 == 2 {
            group.2 = line.to_string();
            groups.push(group);
            group = ("".to_string(), "".to_string(), "".to_string());
        }
    }
    groups
}

fn get_duplicate_characters_from_three_lines(
    line_one: &str,
    line_two: &str,
    line_three: &str,
) -> Vec<char> {
    let mut line_one_characters: Vec<char> = Vec::new();
    let mut line_two_characters: Vec<char> = Vec::new();
    let mut line_three_characters: Vec<char> = Vec::new();
    for character in line_one.chars() {
        line_one_characters.push(character);
    }
    for character in line_two.chars() {
        line_two_characters.push(character);
    }
    for character in line_three.chars() {
        line_three_characters.push(character);
    }
    let mut duplicate_characters: Vec<char> = Vec::new();
    for character in line_one_characters {
        if line_two_characters.contains(&character) && line_three_characters.contains(&character) {
            if !duplicate_characters.contains(&character) {
                duplicate_characters.push(character);
            }
        }
    }
    duplicate_characters
}

fn main() {
    let lines = lines_from_file("input.txt");
    let mut total_score = 0;

    let groups = divide_lines_into_groups_of_three(&lines);

    for line in lines {
        let duplicate_characters = get_duplicate_characters(&line);
        let scores = map_char_score_lowercase(&duplicate_characters);
        let sum: i32 = scores.iter().sum();
        total_score += sum;
        println!("{},{:?}", sum, duplicate_characters);
    }
    //Part two
    for group in groups {
        let duplicate_characters = get_duplicate_characters_from_three_lines(&group.0, &group.1, &group.2);
        let scores = map_char_score_lowercase(&duplicate_characters);
        let sum: i32 = scores.iter().sum();
        total_score += sum;
        println!("{},{:?}", sum, duplicate_characters);
    }
    
    println!("{}", total_score);
}