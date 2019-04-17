package uk.co.syski.client.Collection;

import uk.co.syski.client.System.FileSystem.SystemFile;

import java.io.File;

public class FileCollection
{
    public static File[] getDirectoryContent(String path)
    {
        File f = new File(path);
        return f.listFiles();
    }
}
